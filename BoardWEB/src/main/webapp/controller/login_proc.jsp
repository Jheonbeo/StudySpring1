<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("password");
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(pwd);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	if(user != null){
		response.sendRedirect("..\\getBoardList.jsp");
	}
	else{
		response.sendRedirect("..\\login.jsp");
	}
%>