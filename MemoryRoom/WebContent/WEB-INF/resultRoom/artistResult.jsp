<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>歌手に関する検索結果</title>
</head>

<body>
<%@include file="../searchFilter.html" %>
<%@page import="bean.Artist, java.util.List" %>


<%-- Listから検索結果の取り出し --%>
<%-- アーティスト名がずらーっと入ったListを取得 --%>
<% List<Artist> list = (List<Artist>)request.getAttribute("list");
   for(Artist a : list){ %>
	<%-- URL付きで一覧表示 --%>
	&ensp;<a href="../servlet/Info?name=<%=a.getName() %>&junle=artist"><%=a.getName() %></a><br>
<% } %>

</body>
</html>