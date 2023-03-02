<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of addresses</title>
</head>
<body>
<form method="post" action="addressListNavigationServlet">
<table>
<c:forEach items="${requsetScope.allAddressLists }" var="currentAddressList">
<tr>
	<td><input type="radio" name="id" value="${currentAddress.id }"></td>
	<td><h2>${currentAddressList.detailsName }</h2>
	<tr><td colspan="3">Date created: ${currentAddressList.accessDate}</td></tr>
	<tr><td colspan="3">Resident:${currentAddressList.addresslist.resident }</td></tr>
	<c:forEach var="addressVal" items="${currentAddress.listOfAddresses }"><tr><td></td><td colspan="3">${addressVal.street }, ${addressVal.city }, ${addressVal.state }, ${addressVal.zip }
	</td></tr>
</c:forEach>
</c:forEach>
</table>
</form>
<a href="index.html">Add new addresses.</a>
</body>
</html>