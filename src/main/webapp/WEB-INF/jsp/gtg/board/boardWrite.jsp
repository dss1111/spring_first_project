<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�۾���</h1><br>
	<form action="boardWriteFunction.do" method="post" id="writeform">
	���� : <input type="text" name="title"> <br>
	����: <textarea name="contents" form="writeform" cols="80" row="80"></textarea> <br>
	<input type="submit">
	
	</form>
</body>
</html>