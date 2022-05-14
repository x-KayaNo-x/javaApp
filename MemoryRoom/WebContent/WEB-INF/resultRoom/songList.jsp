<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>曲一覧(未実装)</title>
</head>
<body>
<%@include file="../searchFilter.html" %>
<%@ page import="bean.Song, java.util.List" %>
<%--　Listから検索結果の取り出し --%>
<% List<Song> list = (List<Song>)request.getAttribute("list");%>
<% for(Song a : list){ %>
	&ensp;<%= a.getName()%><br>
<% } %>
<%-- 円盤収録一覧表示 --%>

</body>
</html>