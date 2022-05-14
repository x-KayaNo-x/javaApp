<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>思い出の館</title>
</head>
<body>
<h3>思い出の館へようこそ</h3>
<form action="../servlet/Login" method="post">
お名前: <input type="text" name="name"><br>
鍵　　: <input type="password" name="key"><br>
<p> (↑ PASS: 1224) </p>
<input type="submit" value="鍵を開ける">
</form>
</body>
</html>