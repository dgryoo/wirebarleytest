<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title></head>
<body>
<%
  String name = request.getParameter("name");
  String age = request.getParameter("age");
%>

<h2>이름 : <%= name%></h2>
<h2>나이 : <%= age%></h2>
</body>
</html>

