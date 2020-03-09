<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Delete User</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="../Css/PageStyle.css">
		<script language="JavaScript" type="text/javascript">
			function submitFormToCancel()
			{
			  	document.userAndAccountCreationContainer.cancelOperation.value = 'goBackHome' ;
			  	document.userAndAccountCreationContainer.submit() ;
			}
		</script>
		
		<%@page import="com.data.bean.UserBean"%>
	</head>
	<body>
		<table class="table" >
			<tr>
				<td align="right">
					<%
						String sessionUser = "";
						if ((UserBean)session.getAttribute("loggedOnUser") != null) {
							sessionUser = ((UserBean)session.getAttribute("loggedOnUser")).getFirstName();
						}
					%>
					Welcome <%= sessionUser %>
				</td>
			</tr>
		</table>
		<form id="userDetails" name="userAndAccountCreationContainer" action="../UserAndAccountCreationServlet" method="post">
			<table>
				 <tr>
				    <td>
				    	<label class="label">Gender</label>
				    </td>
				    <td>
				    	<select name="userGender" >
				    		<option value="select">--select--</option>
				  			<option value="male">Male</option>
				  			<option value="female">Female</option>
				  			<option value="other">Other</option>
						</select>
				    </td>
				</tr>
				<tr>
					<td>
						<input type="submit" style="width: 150px;
										height: 40px;
										background-color: #4dff4d;
										border: none;
										color: black;
										padding: 15px 32px;
										text-align: center;
										text-decoration: blink;
										display: inline-block;
										font-size: 15px;
										margin: 4px 2px;
										cursor: pointer;" value="Create">
						<input type="submit" style="width: 150px;
										height: 40px;
										background-color: #4dff4d;
										border: none;
										color: black;
										padding: 15px 32px;
										text-align: center;
										text-decoration: blink;
										display: inline-block;
										font-size: 15px;
										margin: 4px 2px;
										cursor: pointer;" onclick="javascript:submitFormToCancel()" value="Cancel">
					</td>
				</tr>
			</table>
			<input type="hidden" name="cancelOperation" >
		</form> 
	</body>
</html>