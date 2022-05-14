<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料室</title>
</head>
<body>
<%@page import="bean.Cd, java.util.List" %>
<% List<Cd> list = (List<Cd>)request.getAttribute("cdsInfo"); %>
<h2><%=list.get(0).getCdName() %>の資料</h2>
<p>
アーティスト: <%=list.get(0).getName() %>
</p>
<p>
エディション:<br>
<% for (Cd cd : list) { %>
      <%=cd.getCdEdition() %>&ensp;&ensp;
      ¥<%=cd.getPrice() %>&ensp;
      <% if (cd.getPossession() == 1){ %>
      		[所持]
      <% } else { %>
      		[未所持]
      <% } %><br>
  <% } %>
</p>
<p>
発売日: <%=list.get(0).getRelease() %><br>

オリコン最高位: <%=list.get(0).getOriconTop() %><br>
</p>

</body>
</html>