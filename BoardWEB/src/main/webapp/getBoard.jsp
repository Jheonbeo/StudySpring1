<%@page import="com.springbook.biz.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String seq = request.getParameter("seq");

	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));

	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
%>
<form action="controller\updateBoard_proc.jsp" method="post">
<input name="seq" type="hidden" value="<%=board.getSeq() %>"/>W
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" value="<%=board.getTitle()%>" name="title"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><%=board.getWriter()%></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" value="<%=board.getContent()%>" name="content"></td>
	</tr>
	<tr>
		<td>등록일</td>
		<td><%=board.getRegDate()%></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><%=board.getCnt()%></td>
	</tr>
	<tr><td colspan="2"><input type="submit" value="글 수정"></td></tr>
</table>
</form>
<a href="InsertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="controller\deleteBoard_proc.jsp?seq=<%=board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">글 목록</a>&nbsp;&nbsp;&nbsp;