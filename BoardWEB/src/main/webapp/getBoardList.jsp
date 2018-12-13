<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<a href="controller\logout_proc.jsp">Log-out</a><p>
<%
	List<BoardVO> boardList = (List)session.getAttribute("boardList"); //기본적으로 Object 타입으로 리턴됨
%>
<style type="text/css">
body {
	text-align: center;
}

form {
	display: inline-block;
}
</style>
<table border="1">
	<tr>
		<th>번호
		<th>제목
		<th>작성자
		<th>등록일
		<th>조회수
	</tr>
	<%
		for (BoardVO board : boardList) {
	%>
	<tr>
		<td><%=board.getSeq()%></td>
		<td><a href="getBoard.jsp?seq=<%=board.getSeq()%>"><%=board.getTitle()%></td>
		<td><%=board.getWriter()%></td>
		<td><%= board.getRegDate() %></td>
		<td><%= board.getCnt() %></td>
	</tr>
	<%
		}
	%>
</table>