<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所持未所持CD一覧</title>
</head>
<body>
<%@include file="../searchFilter.html" %>
<%@page import="bean.Cd, java.util.List" %>
<%-- 所持、未所持の指定があった場合、エディションごとの表示をしたいのです --%>
<%--　ListのListから検索結果の取り出し --%>
<% List<Cd> list = (List<Cd>)request.getAttribute("list");
   for (Cd c : list) { %>
		<%-- URL付きで一覧表示 --%>
		&ensp;<a href="../servlet/Info?name=<%=c.getCdName() %>&junle=cd"><%=c.getCdName() %>&ensp;&ensp; [<%=c.getCdEdition() %>]</a><br>
<% } %>


</body>
</html>