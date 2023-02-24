<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add,edit,delete</title>
</head>
<body>
<form method="post" action="addressNavigationServlet">
<table>
<c:forEach items="${requestScope.ListAddresses }" var="currentAddress">
<tr>
<td><input type="radio" name="id" value="${currentAddress.id }"></td>
	<td>Street: ${currentAddress.street }, </td>
	<td>City: ${currentAddress.city }, </td>
	<td>State: ${currentAddress.state }, </td>
	<td>Zip code: ${currentAddress.zip }</td>
	</tr>
</c:forEach>
</table>
<input type="submit" value="delete" name="ChangeAddress">
<input type="submit" value="add" name="ChangeAddress">
</form>
</body>
</html>