<%@page import="com.springbook.biz.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String seq = request.getParameter("seq");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	vo.setTitle(title);
	vo.setContent(content);

	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	response.sendRedirect("..\\getBoardList.jsp");
%>