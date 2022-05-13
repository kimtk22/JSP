package com.bit.module01.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class BitEmp {
	Logger log = Logger.getLogger(this.getClass());
	
	public ArrayList<EmpBean> getList() throws ClassNotFoundException, SQLException{
		ArrayList<EmpBean> list = new ArrayList<>();
		String sql = "select empno, ename, sal from emp order by empno desc";
		try(
				Connection conn = BitMysql.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			while(rs.next()) {
				EmpBean bean = new EmpBean();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setSal(rs.getInt("sal"));

				log.debug(bean.toString());
				list.add(bean);
			}
		}
		return list;
	}
	
	public boolean insertOne(int empno, String ename, int sal) throws ClassNotFoundException, SQLException {
		String sql = "insert into emp (empno, ename, sal, hiredate) values("
				+ empno + "," + ename + "," + sal + ",now())";
		
		try(
				Connection conn = BitMysql.getConnection();
				Statement stmt = conn.createStatement();
				){
			return stmt.executeUpdate(sql) > 0 ;
		}
	}
}
