<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index</title>
</head>
<body>
<h1>이것은 index입니다. </h1>
<form action="main/loginFunction.do" method="post">
        아이디 : <input type="text" name="id" size"20"> <br />
        비밀번호 : <input type="password" name="password" size"20"><br />
        <input type="submit" value="테스트">
        <br>
		<input type="button" value="액션" onclick="location.href='main/tt.do'">
</form>
</body>
</html>