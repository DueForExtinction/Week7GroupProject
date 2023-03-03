<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All address lists</title>
</head>
<body>
<form method="post" action="addressListNavigationServlet">
<table>
<c:forEach items="${requestScope.currentAddressList }" var="currentaddresslist">
<tr>
<td><input type="radio" name="id" value="${currentaddresslist.id }"></td>
<td><h2>${currentaddresslist.detailsName }</h2></td></tr>
<tr><td colspan="3">Date created: ${currentaddresslist.accessDate}
<tr><td colspan="3">Resident: ${currentaddresslist.adList.resident}</td></tr>
<c:forEach var="addressVal" items="${currentaddresslist.listOfAddresses }"><tr><td></td><td colspan="3">Address: ${addressVal.street }, ${addressVal.city }, ${addressVal.state }, ${addressVal.zip }
</td></tr>
</c:forEach>
</c:forEach>
</table>
<input type = "submit" value="delete" name="DoThisToList">
</form>

<a href="index.html">Add more addresses</a>
</body>
</html>