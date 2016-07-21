<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Bank WebApp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/scrollreveal.js/3.2.0/scrollreveal.min.js"></script>
	
</head>
<body style="background: rgb(201, 240, 255);">
	<a href="http://localhost:8080/Bank-Struts-App/">
		<div id="header" style="width: 100%; text-align: center; height: 100px; background: rgb(3, 140, 212) none repeat scroll 0% 0%; padding-top: 20px;margin-top:-25px;" data-scrollreveal="enter from the top over 1.5s">
			<h2 style="color:white;"> Bank Web Application</h2>
		</div>
	</a>
	<div style="width: 1310px; margin-left: auto; margin-right: auto;">

		<html:form action="/addAccount" styleId="formAdd"
			style=" display:inline-block;!important;
			    background: rgb(96, 195, 247) none repeat scroll 0% 0%;
				margin-top: 50px;
				padding: 10px;
				margin-left: 15px;
				margin-right: 15px;
				border-radius: 15px;">
			<table border="0"
				style="width: 270px;height:200px; border-radius: 10px; background: #60C3F7;">
				<tbody>

					<tr>
					   <th style="color:white;">Add Account</th>	
					</tr>
					
					<tr>
						<td colspan="2"><span style='color: red'>
							<bean:write name="AddAccountForm" property="error" filter="false" /></span> &nbsp;
						</td>
					</tr>
					
					<c:if test="${not empty AddAccountForm.success}">
						<tr>
	
							<td colspan="2">
								<span style='color: #008000'> 
									<bean:write name="AddAccountForm" property="success" filter="false" />
								</span>
								&nbsp;
							</td>
						</tr>
					</c:if>


					<tr>
						<td>Initial Balance:</td>
						<td><html:text  styleClass="form-control" styleId="initialBalance"
								property="initialBalance" /></td>
					</tr>

					<tr>
						<td>Costumer Name:</td>
						<td><html:text  styleClass="form-control"  styleId="costumerName" property="costumerName" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="button" class="btn" value="Add" onclick="addFunc()" /></td>
					</tr>
				</tbody>
			</table>
		</html:form>
		
		<html:form action="/deposit" styleId="formDeposit"
			style=" display:inline-block;!important;
				background: rgb(96, 195, 247) none repeat scroll 0% 0%;
				margin-top: 50px;
				padding: 10px;
				margin-left: 15px;
				margin-right: 15px;
				border-radius: 15px;">
			<table border="0"
				style="width: 270px;height:200px; border-radius: 10px;  background: #60C3F7;">
				<tbody>
					<tr>
					   <th style="color:white;">Deposit</th>	
					</tr>
					
					
					<tr>
						<td colspan="2"><span style='color: red'><bean:write
									name="DepositAccountForm" property="error" filter="false" /></span> &nbsp;</td>
					</tr>
					
					
					<c:if test="${not empty DepositAccountForm.success}">
						<tr>
	
							<td colspan="2">
								<span style='color: #008000'> 
									<bean:write name="DepositAccountForm" property="success" filter="false" />
								</span>
								&nbsp;
							</td>
						</tr>
					</c:if>
					
					<tr>
						<td>Account Number:</td>
						<td><html:text  styleClass="form-control" styleId="accountNumber"
								property="accountNumber" /></td>
					</tr>

					<tr>
						<td>Amount:</td>
						<td><html:text  styleClass="form-control" styleId="amount" property="amount" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="button" class="btn" value="Deposit"
							onclick="depositFunc()" /></td>
					</tr>
				</tbody>
			</table>
		</html:form>
		
		
		<html:form action="/withdraw" styleId="formWithdraw"
			style=" display:inline-block;!important;
				background: rgb(96, 195, 247) none repeat scroll 0% 0%;
				margin-top: 50px;
				padding: 10px;
				margin-left: 15px;
				margin-right: 15px;
				border-radius: 15px;">
			<table border="0"
				style="width: 270px; height:200px;border-radius: 10px; background: #60C3F7;">
				<tbody>
					<tr>
					   <th style="color:white;">Withdraw</th>	
					</tr>
					
					
					<tr>
						<td colspan="2"><span style='color: red'><bean:write
									name="WithdrawAccountForm" property="error" filter="false" /></span> &nbsp;</td>
					</tr>
					
					
					<c:if test="${not empty WithdrawAccountForm.success}">
						<tr>
	
							<td colspan="2">
								<span style='color: #008000'> 
									<bean:write name="WithdrawAccountForm" property="success" filter="false" />
								</span>
								&nbsp;
							</td>
						</tr>
					</c:if>
					
					<tr>
						<td>Account Number:</td>
						<td><html:text  styleClass="form-control" styleId="accountNumberW"
								property="accountNumber" /></td>
					</tr>

					<tr>
						<td>Amount:</td>
						<td><html:text  styleClass="form-control" styleId="amountW" property="amount" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="button" class="btn" value="Withdraw"
							onclick="withdrawFunc()" /></td>
					</tr>
				</tbody>
			</table>
		</html:form>
		
		<html:form action="/transfer" styleId="formTransfer"
			style=" display:inline-block;!important;
				background: rgb(96, 195, 247) none repeat scroll 0% 0%;
				margin-top: 50px;
				padding: 10px;
				margin-left: 15px;
				margin-right: 15px;
				border-radius: 15px;">
			<table border="0"
				style="width: 270px; height:200px; border-radius: 10px; background: #60C3F7;">
				<tbody>
					<tr>
					   <th style="color:white;">Transfer</th>	
					</tr>
					
					
					<tr>
						<td colspan="2"><span style='color: red'><bean:write
									name="TransferAccountForm" property="error" filter="false" /></span> &nbsp;</td>
					</tr>
					
					
					<c:if test="${not empty TransferAccountForm.success}">
						<tr>
	
							<td colspan="2">
								<span style='color: #008000'> 
									<bean:write name="TransferAccountForm" property="success" filter="false" />
								</span>
								&nbsp;
							</td>
						</tr>
					</c:if>
					
					<tr>
						<td>From:</td>
						<td><html:text  styleClass="form-control" styleId="from" property="from" /></td>
					</tr>

					<tr>
						<td>To:</td>
						<td><html:text  styleClass="form-control" styleId="to" property="to" /></td>
					</tr>
					<tr>
						<td>Amount:</td>
						<td><html:text  styleClass="form-control" styleId="amountT" property="amount" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="button" class="btn" value="Transfer"
							onclick="transferFunc()" /></td>
					</tr>
				</tbody>
			</table>
		</html:form>
		
		<html:form action="/showData" styleId="formShowData"
			style=" display:inline-block;!important; margin-top:35px; width: 1290px;">
			<div style="width:250px;margin-left:auto;margin-right:auto;">
			
				<input type="button" class="btn btn-success" style="width:250px;margin-left:auto;margin-right:auto;"value="Show Data"
							onclick="showDataFunc()" />
			</div>
			
			<c:if test="${not empty accounts}">
				<table border="0" class="table"
					style="width: 1265px; margin-bottom: 100px; height:100px; border-radius: 10px; margin-top: 10px; background: #60C3F7;margin-left: 15px;">
					<tbody>
						<tr>
								<th style="color:white;">Account Number</th>
								<th style="color:white;">Costumer Name</th> 
								<th style="color:white;">Cash Amount</th>
						</tr>
						<c:forEach items="${accounts}" var="accounts">
							<tr>
								
								<td><c:out value="${accounts.acountNumber}"/></td>
								<td><c:out value="${accounts.customerName}"/></td>
								<td><c:out value="${accounts.initialBalance}"/></td>
								
							</tr>
						</c:forEach>
						
					</tbody>
				
				</table>
			</c:if>
		</html:form>
	
	</div>
	
	<div id="footer"  style="position:fixed; bottom: 0; width: 100%; text-align: center; height: 50px; background: rgb(3, 140, 212) none repeat scroll 0% 0%; padding:10px;">
		<h5 style="color:white;">© Copyright Vlad Airinei </h5>
	</div>

</body>
<script type="text/javascript">

	
	function addFunc()
	{
		var form = document.getElementById("formAdd");
		//Verify the field name	
		if (document.getElementById("costumerName").value != "")
		{
			form.action = "addAccount.do?method=addAccount";
			form.submit();
		}
		else alert("Insert costumer name!");
	}

	
	function depositFunc()
	{	
		
		var form = document.getElementById("formDeposit");
		//Verify the field name	
		if (document.getElementById("accountNumber").value != "" && document.getElementById("amount").value != "")
		{
			form.action = "deposit.do?method=depositAccount";
			form.submit();
		}
		else alert("Complete both fields!");
	}
	
	function withdrawFunc()
	{
		
		var form = document.getElementById("formWithdraw");
		//Verify the field name	
		if (document.getElementById("accountNumberW").value != "" && document.getElementById("amountW").value != "")
		{
			form.action = "withdraw.do?method=withdrawAccount";
			form.submit();
			
		}
		else alert("Complete both fields!");
	}
	
	function transferFunc()
	{
		
		var form = document.getElementById("formTransfer");
		//Verify the field name	
		if (document.getElementById("to").value != "" && document.getElementById("from").value != ""&& document.getElementById("amountT").value != "")
		{
			form.action = "transfer.do?method=transferAccount";
			form.submit();
			
		}
		else alert("Complete both fields!");
	}
	
	function showDataFunc()
	{
		
		var form = document.getElementById("formShowData");
		//Verify the field name	

		form.action = "showData.do?method=showDataAcounts";
		form.submit();
	}

	//Animatii
	if(document.URL.indexOf(".do") == -1) {
		window.sr = ScrollReveal();
		sr.reveal('#header');
		sr.reveal('#footer');
		sr.reveal('#formAdd', { delay: 500, scale: 0.3 });
		sr.reveal('#formDeposit', { delay: 830, scale: 0.3 });
		sr.reveal('#formWithdraw', { delay: 1160, scale: 0.3 });
		sr.reveal('#formTransfer', { delay: 1490, scale: 0.3 });
		sr.reveal('#formShowData', { delay: 1730, scale: 0.3 });
	}
	
	
</script>


</html>