<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>LogIn Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="../Css/PageStyle.css">
		<script language="JavaScript" type="text/javascript">
			function pageLoad() 
			{
				var isUserCreated = document.logInHomeContainer.userAccountCreationCheck.value;
				
			    if (isUserCreated == "true") {
			    	document.getElementById("successMessage").style = 'visibility: visible; color: ##003300; font-style: italic; font-weight: bold; text-align: center;';
			    }
			    window.history.forward();
			}
		    setTimeout("pageLoad()", 0);
			function submitForm(navigation)
			{
			  	document.logInHomeContainer.userSelection.value = navigation ;
			  	document.logInHomeContainer.submit() ;
			}
			window.onload = pageLoad;
		</script>
		
		<%@page import="com.data.bean.UserBean"%>					
	</head>
	<body class="body">
		<table align="right" >
			<tr>
				<td>
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
		<p><p>
		<table align="center">
			<tr>
				<td>
					<h4><label id="successMessage" style="visibility: hidden;" >The User and Account are created successfully. Happy Banking!!!</label></h4>
				</td>
			</tr>
		</table>
		<h1 align="center" >Select one from the below operations</h1>
		<form name="logInHomeContainer" method="post" action="../LogInHomeServlet">
			<input type="hidden" name="userSelection">
		   	<table align="center" class="linktable">
			  <tr class="linktr" >
			    <td class="linktd" >
					<a href="javascript:submitForm('userAndAccountCreation')" class="link" >Create User and Account</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('deleteUser')" class="link" >Delete User</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('addAccount')" class="link" >Add Account</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('deleteAccount')" class="link" >Delete Account</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('updateBalance')" class="link" >Update Balance</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('makeTransaction')" class="link" >Make A Transaction</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('viewBalanceAndStatement')" class="link" >View Balance and Statement</a>
			    </td>
			  </tr>
			  <tr class="linktr" >
			    <td class="linktd" >
			    	<a href="javascript:submitForm('viewUser')" class="link" >View User</a>
			    </td>
			  </tr>
			</table>
			<table align="center" >
				<tr>
					<td>
						<input align="middle" type="submit" class="button" value="LogOut">
					</td>
				</tr>
			</table>
			<%
			  	Boolean isUserAccountCreated = (Boolean)request.getServletContext().getAttribute("userAccountCreated");
		  		request.getServletContext().setAttribute("userAccountCreated", new Boolean(false));
			%>
			<input type="hidden" name="userAccountCreationCheck" value="<%=isUserAccountCreated%>">
		</form>
	</body>
</html>