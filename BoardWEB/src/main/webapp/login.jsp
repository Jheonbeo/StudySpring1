<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

form {
	display: inline-block;
}
</style>
</head>
<body>
	<form action="login.do" method="post">
		아이디 : <input type="text" name="id"><br> 
		비밀번호 : <input type="password" name="password"><br> 
		<input type="submit" value="로그인">
	</form>


</body>
</html>