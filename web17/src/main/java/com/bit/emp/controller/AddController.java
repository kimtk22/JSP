package com.bit.emp.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

@WebServlet("/emp/add.html")
public class AddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/emp/add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Enumeration<String> names = req.getParameterNames();
		
		Map<String, String[]> items = req.getParameterMap();
		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename = req.getParameter("ename");

		EmpDao dao = new EmpDao();
		dao.insertOne(items);
		resp.sendRedirect("list.html");

	}
}
