<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create employee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<style>
#form1 {
  font-family: arial;
  font-size: 24px;
  margin: 25px;
  width: 350px;
  height: 200px;
  outline: dashed 2px black;
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
<center><h1>Create Employee</h1></center>
<div id="form1">
<form action = "CreateEmp" method="post">
<label>Enter employee name</label><br>
<input type=text name="empName"><br>
<label>Enter salary amount</label><br>
<input type =number name="salary"><br>
<label>Enter designation</label><br>
<input type=text name="designation"><br>
<button class="btn btn-primary">Submit</button>

</form>
</div>
<a class="btn btn-warning" href="index.jsp">--home</a>
</body>
</html>