<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new address list</title>
</head>
<body>
<form action ="createNewAddressListServlet" method="post">
List name: <input type="text" name="detailsName"><br/>
Date:<input type="text" name="month" placeholder="mm" size="4">
<input type="text" name="day" placeholder="dd" size="4">
<input type="text" name="year" placeholder="yyyy" size="4">
Resident name: <input type="text" name="resident"><br/>

Available addresses:<br/>
<select name="allAddressesToAdd" multiple size="6">
<c:forEach items="${requestScope.allAddresses }" var="currentAddress">
<option value="${currentAddress.id }">${currentAddress.street } | ${currentAddress.city } | ${currentAddress.state } | ${currentAddress.zip }</option> 
</c:forEach>
</select>
<br/>
<input type="submit" value="Create list and add addresses">
</form>
<a href ="index.html">Create more addresses.</a>
</body>
</html>