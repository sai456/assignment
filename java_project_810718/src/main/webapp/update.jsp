<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update employee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<style>
#form1 {
  font-family: arial;
  font-size: 24px;
  margin: 25px;
  width: 350px;
  height: 200px;
  outline: dashed 1px black;
  margin-left:500px;
}
form {
  text-align: center;
}
</style>
<body>
<%
String message=(String)request.getAttribute("msg");
if(message!=null)
{
%>
<%=message %>
<%} %>
<div id="form1">
<form action="UpdateEmp" method ="post">
<label>Enter the employee name</label><br>
<input type="text" name="empName"><br>
<label>Enter the amount to increase in salary</label><br>
<input type="number" name="salary"><br>
<button class="btn btn-info">Submit</button>
</form>
</div>
<a class="btn btn-warning" href="index.jsp">home</a>
</body>
</html>