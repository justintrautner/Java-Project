<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About</title>
<link rel="stylesheet" type="text/css" href="css/foundation.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>


	<!-- Body -->
	<div class="grid-container">
		<div class="grid-x grid-padding-x">
		<div class="cell small-12 medium-6">
			<fieldset class="fieldset">
			<legend>Admin Login</legend>
			<form action="/login" method="post">
				<label>Name:</label>
				<input type="text" name="name"> 
				<label>Password:</label>
				<input type="password" name="password"> 
				<input type="submit" value="Login!" class="button success">
			</form>
			</fieldset>
		</div>
		</div>
	</div>


	<script src="js/vendor/jquery.js"></script>
	<script src="js/vendor/what-input.js"></script>
	<script src="js/vendor/foundation.min.js"></script>
	<script src="js/app.js"></script>

</body>
</html>