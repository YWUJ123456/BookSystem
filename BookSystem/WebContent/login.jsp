<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅管理系统-登录</title>
	<style type="text/css">
	#div1{
		background-color:rgb(239,245,251);
		height:100px;
		width:100%;
	}
	#h1_1{
		position:relative;
		top:20px;
	}
	#img1{
		position:relative;
		left:50px;
		padding:13px;
	}
	a{
		text-decoration:none;
	}
	#div2{
		height:400px;
		width:100%;
	}
	#div2_3{
		height:300px;
		width:300px;
		position:relative;
		left:515px;
		top:50px;
	}
	#tr1{
		background-color:rgb(239,245,251);
	}
	#button1{
		background-color:rgb(90,153,223);
		height:30px;
		width:200px;
	}
	#table1{
		height:300px;
		width:300px;
		align:center;
		border:solid 1px rgb(109,150,201);
	}
	#input1,#input2{
		height:30px;
		width:200px;
	}

	#div3{
		background-color:rgb(239,245,251);
		height:80px;
		width:100%;
		text-align:center;
	}
	#div3_1{
		position:relative;
		top:20px;
	}
	</style>
</head>

<body>
	<div id="div0">
		<div id="div1">
			<h1 align="center" id="h1_1">图书借阅管理系统</h1>
		</div>
		<div id="div2">
			<div id="div2_3">
				<form action="/BookSystem/login" method="post">
					<table id="table1" >
					<tr id="tr1">
						<td colspan="4" align="center">
							<input type="radio" name="role" value="0">用户登录
							<input type="radio" name="role" value="1">管理员登录
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input id="input1" type="text" name="username" placeholder="账号"/></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input id="input2" name="password" placeholder="密码" type="password" /></td>
					</tr>
					<tr>
						<td colspan="4">
						&nbsp&nbsp&nbsp&nbsp
							<input type="checkbox" name="auto" value="autoLogin"/>下次自动登录
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<button id="button1" >登录</button>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<font fo><a href="">忘记密码？</a> 
							| <a href="">注册新账号</a> 
							| <a href="">意见反馈</a></font>
						</td>
					</tr>
					</table>
				</form>
				<h5>${msg}</h5>
			</div>
		</div>
		<div id="div3">
			<div id="div3_1">
				<h4><a href="">关于我们</a> 
				| <a href="">服务条款</a> 
				| <a href="">客服中心</a>
				| <a href="">联系我们</a>
				| <a href="">帮助中心</a>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>