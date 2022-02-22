<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.EmpDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<form action="GetAllDetails" method="post">
<button class="btn btn-secondary" onclick="GetAllDetails">Click here to display</button>
</form>
<table  class="table table-dark table-hover">
<thead>
<tr>
	<th>ID</th>
	<th>Employee name</th>
	<th>Salary</th>
	<th>Designation</th>
</tr>
</thead>
<tbody>
<%

List<EmpDetails> empList =(ArrayList<EmpDetails>)request.getAttribute("empList");
if(empList!=null)
for(EmpDetails emp:empList){

%>

<tr>
	<td><%=emp.getId() %></td>
	<td><%=emp.getName() %></td>	
	<td><%=emp.getSalary() %></td>	
	<td><%=emp.getDesignation() %></td>		
</tr>
<% } %>
</tbody>
</table>

<a href="index.jsp">home</a>
</body>

</html>