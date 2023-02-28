<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Address</title>
</head>
<body>
<form action="editAddressServlet" method ="post">
Street: <input type="text" name ="street" value ="${addressToEdit.street }">
City: <input type="text" name ="city" value ="${addressToEdit.city }">
State: <input type="text" name ="state" value ="${addressToEdit.state }">
Zip: <input type="text" name ="zip" value ="${addressToEdit.zip }">
<input type ="hidden" name="id" value ="${itemToEdit.id }">
<input type="submit" value="Save Edited Item">
</form>

</body>
</html>