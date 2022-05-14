<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>思い出の部屋-マイルーム-</title>
</head>
<body>
<h2>思い出の部屋</h2>
<%@include file="../searchFilter.html" %>
<br><br><br><br>
<ul class="top-nav">
<li><a href="../servlet/Search?junle=artist&possession=2&keyword=">アーティスト一覧</a></li>
<li><a href="../servlet/Search?junle=cd&possession=2&keyword=">CD一覧</a></li>
</ul>
<br><br><br><br>

</body>
<footer>
<form action="../servlet/Logout" method="get" >
<input type="submit" value="外に出る">
</form>
</footer>
</html>