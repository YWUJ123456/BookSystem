<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅管理系统-管理员页面</title>
<style>
	body{
		background: url(img/preview.jpg) no-repeat ;
	}
	div{
		text-align:center;
	}
	.divtable{
		margin:30px;
	}
	table tr td{
		border:solid 1px black;
		text-align:center;
	}
</style>
</head>
<body>
	<div class="divtable">
		<div>
			<!-- 查询 -->
			<form action="search">
				书名:<input type="text" name="name">
				出版社:<input type="text" name="publish">
				作者:<input type="text" name="author">
				<button>查询</button>
			</form>
			<br><br>
			
			<form action="allSave" method="post" enctype="multipart/form-data">
				<input type="file" name="myfile"><button>批量导入</button>
				<a href="souBook.jsp"><button type="button">单个添加</button></a>
				<a href="check"><button type="button">审核归还书籍</button></a>
			</form>
			<br><br>
		</div>
		
		<!-- 图书信息 -->
		<div>
			<form action="/BookSystem/del">
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
					<td>删除</td>
					<td>修改</td>
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
						<td><a href="del?id=${book.id}"><button type="button">删除</button></a></td>
						<td><a href="upd?id=${book.id}"><button type="button">修改</button></a></td>
					</tr>
				</c:forEach>
			</table><br>
		<button id="del_button">删除选中</button>
		</form>
		</div>	
		
		<!-- 分页插件 -->
		<div class="p_btn">
			<c:set var="pager_url"	value="toadmin" />
			<c:set var="param_target" value="divtable" />
			<jsp:include page="include/four.jsp">
				<jsp:param name="url" value="${pager_url }" />
				<jsp:param name="target" value="${param_target }" />
			</jsp:include>
		</div> 
		
	</div>

</body>
</html>