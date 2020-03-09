<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="../Css/PageStyle.css">
		<style>
			body {
				background-color: #e6f2ff;
			}
			table {
			  font-family: arial, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			}
			
			td {
			  border: 1px solid #dddddd;
			  text-align: left;
			  padding: 8px;
			}
			
			th {
			  background-color: #0099cc;
			  border: 1px solid #dddddd;
			  text-align: left;
			  padding: 8px;
			}
			
			tr:nth-child(even) {
			  background-color: #dddddd;
			}
		</style>
	</head>
	<body>
		<table class="table" >
			<tr>
				<th colspan="3">Please Enter The Account Details Below:</th>
			</tr>
			<tr>
				<td>
					<label class="label">Branch</label>
				</td>
				<td>
					<input name="userBranch" type="text" class="textbox">
				</td>
			</tr>
			<tr>
				<td>
					<label class="label">Account Type</label>
				</td>
				<td>
					<input type="radio" name="userAccountType" value="savings"> Savings<br>
					<input type="radio" name="userAccountType" value="current"> Current<br>
					<input type="radio" name="userAccountType" value="demat"> Demat
				</td>
			</tr>
			<tr>
				<td>
					<label class="label">Salary Account</label>
				</td>
				<td>
					<input name="userSalaryAccount" type="checkbox" class="textbox">
				</td>
			</tr>
			<tr>
				<td>
					<label class="label">Initial Deposit</label>
				</td>
				<td>
					<input name="userInitialDeposit" type="text" class="textbox">
				</td>
			</tr>
		</table>
	</body>
</html>