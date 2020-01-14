<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�Խ��� ���</title>
</head>
<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
		display: blue;
		width: 60%;
		margin: auto;
	}
	a {
		text-decoration: none;
	}
</style>
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="gtg/board/boardPaging?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
<body>
<h2>�Խ���</h2>

<div id="outter">
	<table>
		<tr>
			<td>No.</td>
			<td width="50%">����</td>
			<td>�ۼ���</td>
			<td>�����</td>
			<td>��ȸ��</td>		
		</tr>
		<c:forEach items="${viewAll }" var="list">
			<tr>
				<td>${list.num }</td>
				<td><a href="boardView.do?boardNum=${list.num}">${list.title }</td>
				<td>${list.writer }</td>
				<td>${list.wdate }</td>
				<td>${list.count }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="boardPaging.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="boardPaging.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="boardPaging.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
	<input type="button" value="�۾���" onclick="location.href='boardWrite.do'">
</div>
</body>
</html>