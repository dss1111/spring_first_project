<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index</title>
</head>
<body>
<h1>�̰��� index�Դϴ�. </h1>
<form action="loginFunction.do" method="post">
        ���̵� : <input type="text" name="id" size"20"> <br />
        ��й�ȣ : <input type="password" name="password" size"20"><br />
        <input type="submit" value="�α���">
	<input type="button" value="ȸ������" onclick="location.href='signUp.do'">
</form>
</body>
</html>