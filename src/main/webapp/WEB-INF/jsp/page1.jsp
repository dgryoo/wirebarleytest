<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title></head>
<body>
<h1>환율계산</h1>
<h2>송금국가 : 미국(USD)</h2>
<h2>수취국가 : </h2>




<select name=recipientCountry>
    <option value="KRW">한국(KRW)</option>
    <option value="JPY">일본(JPY)</option>
    <option value="PHP">필리핀(PHP)</option>
</select>

<h2>환율 : ${so}</h2>


송금액 : <input type="text" name="usdCount"> USD

<form name="form" action="page2.jsp" method="get">
    이름 : <input type="text" name="name">
    나이 : <input type="text" name="age">
    <input type="submit" value="제출">
</form>


</body>
</html>

