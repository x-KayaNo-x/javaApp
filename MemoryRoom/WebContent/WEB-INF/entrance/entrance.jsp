<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "bean.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>鍵の照合結果</title>
</head>
<body>

<% if (loginUser != null) { %>
	<h3>鍵が開きました</h3>
	<p>おかえりなさい、<%=loginUser.getName() %>さん</p>
	<form action="../servlet/Login" method="get">
	<a href="">部屋に行く</a>
	</form>
<% } else { %>
	<h3>鍵が間違っているようです</h3>
	<a href="../entrance/entranceTop.jsp">ほかの鍵で試す</a>
<% } %>

</body>
</html>