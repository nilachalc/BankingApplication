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
		<table class="table">
			  <tr>
			    <th colspan="3" >Please Enter The User Details Below:</th>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">First Name</label>
			    </td>
			    <td>
			    	<input name="userFirstName" type="text" class="textbox" >
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Last Name</label>
			    </td>
			    <td>
			    	<input name="userLastName" type="text" class="textbox" >
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Address</label>
			    </td>
			    <td>
				    <textarea rows="4" cols="50" name="userAddress"></textarea>
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Mobile</label>
			    </td>
			    <td>
			    	<input name="userMobile" type="text" class="textbox" >
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Email</label>
			    </td>
			    <td>
			    	<input name="userEmail" type="text" class="textbox" >
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Age</label>
			    </td>
			    <td>
			    	<input name="userAge" type="text" class="textbox" >
			    </td>
			  </tr>
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
			    	<label class="label">Password</label>
			    </td>
			    <td>
			    	<input name="userPassword" type="password" class="textbox" >
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<label class="label">Confirm Password</label>
			    </td>
			    <td>
			    	<input name="userConfirmUserPassword" type="password" class="textbox" >
			    </td>
			  </tr>
		</table>
	</body>
</html>