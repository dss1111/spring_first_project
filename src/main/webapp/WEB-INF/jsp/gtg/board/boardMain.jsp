<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
	<thead>
	<tr>
		<th>��ȣ</th>
		<th>����</th>
		<th>����</th>
		<th>�ۼ���</th>
		<th>�ۼ���</th>
	</tr>
	<br><br>
		<c:forEach items="${boardList}" var="list">
	<tr>
		<td>${list.num}</td>
		<td>${list.title}</td>
		<td>${list.contents}</td>
		<td>${list.writer}</td>
		<td>${list.wdate }</td>
	</tr>
	</c:forEach>
	</table>
	<a href="boardWrite.do">�۾���</a>
</body>
</html>