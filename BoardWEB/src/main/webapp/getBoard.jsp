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
		<td>����</td>
		<td><input type="text" value="<%=board.getTitle()%>" name="title"></td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td><%=board.getWriter()%></td>
	</tr>
	<tr>
		<td>����</td>
		<td><input type="text" value="<%=board.getContent()%>" name="content"></td>
	</tr>
	<tr>
		<td>�����</td>
		<td><%=board.getRegDate()%></td>
	</tr>
	<tr>
		<td>��ȸ��</td>
		<td><%=board.getCnt()%></td>
	</tr>
	<tr><td colspan="2"><input type="submit" value="�� ����"></td></tr>
</table>
</form>
<a href="InsertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
<a href="controller\deleteBoard_proc.jsp?seq=<%=board.getSeq() %>">�� ����</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;