<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅管理系统-管理员审核页面</title>
</head>
<style>
	table tr td{
		border:solid 1px black;
	}
</style>
<body>
	<div>	
		<div>
			<table align="center">
				<tr>
					<td>编号</td>
					<td>封面</td>
					<td>书名</td>
					<td>价格</td>
					<td>出版社</td>
					<td>出版日期</td>
					<td>作者</td>
					<td>剩余数量</td>
					<td>用户id</td>
					<td>审核</td>
				</tr>
				<c:forEach items="${map}" var="entry">
					<tr>
						<td><input type="checkbox" name="id" value="${entry.key.id}"></td>
						<td><img alt="没有图片" src="${entry.key.img}" width="20" height="20"></td>
						<td>${entry.key.name}</td>
						<td>${entry.key.price}</td>
						<td>${entry.key.publish}</td>
						<td> <fmt:formatDate value="${entry.key.dob}" pattern="YYYY-MM-dd hh-mm-ss"/> </td>
						<td>${entry.key.author}</td>
						<td>${entry.key.num}</td>
						<td>${entry.value}</td>
						<td><a href="pass?bookid=${entry.key.id}&pid=${entry.value }"><button type="button">审核</button></a></td>
					</tr>
				</c:forEach>
			</table><br>
		</div>
	</div>
</body>
</html>