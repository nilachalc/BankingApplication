<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>LogIn here</title>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="Css/PageStyle.css">
		<script language="JavaScript" type="text/javascript">
			function pageLoad() 
			{
				var isUserCreated = document.credentialCheckContainer.userCreationCheck.value;
				
			    if (isUserCreated == "true") {
			    	document.getElementById("successMessage").style = 'visibility: visible; color: ##003300; font-style: italic; font-weight: bold; text-align: center;';
			    }
			    
			    window.history.forward();
			}
		    setTimeout("pageLoad()", 0);
			function submitForm()
			{
				document.credentialCheckContainer.userName.value = '';
				document.credentialCheckContainer.password.value = '';
			  	document.credentialCheckContainer.submit() ;
			}
			window.onload = pageLoad;
		</script>
	</head>
	<body class="body" >
		<h2 align="center">LogIn Page</h2>
		<h4 align="center"><label id="successMessage" style="visibility: hidden;" >The User is created successfully. Please login to continue!!!</label></h4>
		<form name="credentialCheckContainer" method="post" action="LogInServlet">
		   	<table align="center" class="table">
			  <tr class="tr">
			    <td class="td">
			    	<label class="label">UserName</label>
			    </td>
			    <td class="td">
			    	<input name="userName" type="text" class="textbox" >
			    </td>
			  </tr>
			  <tr class="tr">
			    <td class="td">
			    	<label class="label">Password</label>
			    </td>
			    <td class="td">
			    	<input type="password" name="password" class="textbox" >
			    </td>
			  </tr>
			  <tr class="tr">
			  	<td class="td"></td>
			  	<td class="td">
			  		<input type="submit" class="button" value="GO">
			  	</td>
			  </tr>
			</table>
		  	<h4 align="center" >New User? Please <a href="javascript:submitForm()" >Register</a> with us.</h4>
		  	<%
			  	Boolean isUserCreated = (Boolean)request.getServletContext().getAttribute("userCreated");
		  		request.getServletContext().removeAttribute("userCreated");
			%>
			<input type="hidden" name="userCreationCheck" value="<%=isUserCreated%>">
		</form>
	</body>
</html>