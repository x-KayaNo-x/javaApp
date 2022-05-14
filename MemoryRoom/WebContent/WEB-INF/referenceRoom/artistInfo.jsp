<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料室</title>
</head>
<body>
<%@page import="bean.Artist" %>
<% Artist inf = new Artist(); %>
<% inf = (Artist)request.getAttribute("artist"); %>
<h2><%=inf.getName() %>の資料</h2>
<p>生年月日　　: <%=inf.getBirthDay() %></p>
<p>出身地　　　: <%=inf.getBirthPlice() %></p>
<p>血液型　　　: <%=inf.getBloodType() %>
<% if (inf.getName().equals("柿原徹也")){%>
(RH-)
<% } %></p>
<p>性別　　　　: <%=inf.getGender()%>
<% if (inf.getGender().equals("男") || inf.getGender().endsWith("女")){ %>
性
<% } %></p>
<p>所属レーベル: <%=inf.getLebel() %></p>
<br><br>
<p>どんな推し？: <%=inf.getIntroduct() %>
</p>
</body>
</html>