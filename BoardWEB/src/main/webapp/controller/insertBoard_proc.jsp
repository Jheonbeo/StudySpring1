<%@page import="com.springbook.biz.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");

	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(vo);
	
	response.sendRedirect("..\\getBoardList.jsp");
%>