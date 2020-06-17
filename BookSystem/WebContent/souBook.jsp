<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅管理系统-更新添加页面</title>
<style>
	div{
		text-align:center;
		margin:50px;
	}
	table{
		text-align:center;
		border:solid 1px black;
	}
</style>
</head>
<body>
	<div>
		<form action="sou" method="post" enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td>  书名   :</td> <td><input type="text" name="name" required value="${book.name}"></td>
				</tr>
				<tr>
					<td>  价格   :</td> <td> <input type="text" name="price" required value="${book.price}"></td>
				</tr>
				<tr>
					<td> 出版社 :</td> <td> <input type="text" name="publish" required value="${book.publish}"></td>
				</tr>
				<tr>
					<td>   剩余数量 :</td> <td> <input type="text" name="num" required value="${book.num}"></td>
				</tr>
				<tr>
					<td>  作者 :</td> <td> <input type="text" name="author" required value="${book.author}"></td>
				</tr>
				<tr>
					<td>  封面 : </td> <td><input type="file" name="img" required value="${book.img}"></td>
				</tr>
			</table>
			<br><button>提交</button>
			<br><input type="text" hidden="hidden" name="id" value="${book.id}">	  
		</form>
	</div>
</body>
</html>