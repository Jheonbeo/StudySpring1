<%@page import="com.springbook.biz.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	BoardVO board = (BoardVO)session.getAttribute("board");
%>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq}"/>
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" value="${board.title}" name="title"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${board.writer}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" value="${board.content}" name="content"></td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${board.regDate}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${board.cnt}</td>
	</tr>
	<tr><td colspan="2"><input type="submit" value="글 수정"></td></tr>
</table>
</form>
<a href="InsertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%=board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글 목록</a>&nbsp;&nbsp;&nbsp;