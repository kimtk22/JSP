<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String[] params = {
			request.getParameter("empno"),
			request.getParameter("ename"),
			request.getParameter("sal")
	};
	int empno = Integer.parseInt(params[0].trim());
	String ename = params[1].trim();
	int sal = Integer.parseInt(params[2].trim());
	
	String sql = "update emp set ename='"+ename+"',sal=" + sal + " where empno=" + empno;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott";
	String user = "user01";
	String pw = "1234";
	
	Class.forName(driver);
	Connection conn = null;
	Statement stmt = null;
	try{
		conn = DriverManager.getConnection(url, user, pw);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	%>
</body>
</html>