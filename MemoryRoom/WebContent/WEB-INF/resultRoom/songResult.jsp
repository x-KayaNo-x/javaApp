<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>曲に関する検索結果</title>
</head>
<body>
<%@include file="../searchFilter.html" %>

<%@ page import="bean.Song, java.util.List" %>
<%--　Listから検索結果の取り出し --%>
<% List<Song> songlist = (List<Song>)request.getAttribute("songlist"); %>
<% for(Song song : songlist){ %>
	&ensp;<%= song.getSongName()%><br>
<% } %>
<%--　検索ワードの表示 --%>

<%-- 一覧表示 --%>

</body>
</html>