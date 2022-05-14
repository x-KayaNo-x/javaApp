<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CDに関する検索結果</title>
</head>
<body>
<%@include file="../searchFilter.html" %>
<%@ page import="bean.Cd, java.util.List" %>
<%--　Listから検索結果の取り出し --%>
<% List<Cd> list = (List<Cd>)request.getAttribute("list");%>
<%-- 重複を取り除き、URL付きで一覧表示 --%>
<%
for(int i = 0; i < list.size(); i++){ 
	if(i == 0){
%>
		&ensp;<a href="../servlet/Info?name=<%=list.get(i).getCdName() %>&junle=cd"><%=list.get(i).getCdName() %></a><br>
<%	} else {
		if( !list.get(i).getCdName().equals(list.get(i-1).getCdName()) ){
%>
			&ensp;<a href="../servlet/Info?name=<%=list.get(i).getCdName() %>&junle=cd"><%=list.get(i).getCdName() %></a><br>
<%		}	
	}
%>
	
<% } %>


</body>
</html>