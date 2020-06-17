<%@page import="com.briup.bean.Bp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅管理系统-普通用户页面</title>
<style>
	body{
		background: url(img/preview.jpg) no-repeat ;
	}
	div{
		text-align:center;
	}
	#div1{
		margin:50px;
	}
	table tr td{
		border:solid 1px black;
		text-align:center;
	}
	#div2{
		margin:50px;
	}
</style>
</head>
<body>
	<div class="divtable">
		<div id="div2">
			<a href="showBorrow"><button>已借书籍</button></a>
		</div>
		
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
					<td>借阅</td>
				</tr>
				<c:forEach items="${simplePage.list}" var="book">
					<tr>
						<td><input type="checkbox" name="id" value="${book.id}"></td>
						<td><img alt="没有图片" src="${book.img}" width="20" height="20"></td>
						<td>${book.name}</td>
						<td>${book.price}</td>
						<td>${book.publish}</td>
						<td> <fmt:formatDate value="${book.dob}" pattern="YYYY-MM-dd hh-mm-ss"/> </td>
						<td>${book.author}</td>
						<td>${book.num}</td>
						<td>
							<c:if test="${book.num>0 }">
								<a href="borrow?id=${book.id }"><button type="button">借阅</button></a>
							</c:if>
							<c:if test="${book.num<=0 }">库存不足</c:if>
						</td>
					</tr>
				</c:forEach>
			</table><br>
		</div>
		
		<!-- 分页插件 -->
		<div class="p_btn">
			<c:set var="pager_url"	value="toindex" />
			<c:set var="param_target" value="divtable" />
			<jsp:include page="include/four.jsp">
				<jsp:param name="url" value="${pager_url }" />
				<jsp:param name="target" value="${param_target }" />
			</jsp:include>
		</div> 
		
	</div>
</body>
</html>