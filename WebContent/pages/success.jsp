<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ADD Success</title>
</head>
<body>

	<table border="0"style="width:270px;border-radius: 10px;margin-left:auto;margin-right:auto;margin-top:150px;background:#60C3F7;">
        <tbody>
            <tr>
                <td><h1>Add completed!</h1></td>
                
            </tr>
            <tr>    
                <td><p>You have successfully added a new account.</p></td>
            </tr>
            <tr>    
                <td><p>Bank acount number is: <bean:write name="AddAccountForm" property="accountNumber" />.</</p></td>
            </tr>
            <tr>
                <td><p>Bank acount amount is: <bean:write name="AddAccountForm" property="initialBalance" />.</p></td>
            </tr>
            <tr>
                <td><p>Costumer name is: <bean:write name="AddAccountForm" property="costumerName" />.</p></td>
         
            </tr>
            
        </tbody>
    </table>

</body>
</html>