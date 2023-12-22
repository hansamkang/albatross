<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Twitter Login Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="keywords" content="Form,flex, ,Twitter form ,sachindusahan,html,css" />
<link rel="stylesheet" href="/resources/assets/css/login.css"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Twitter Login Form - Code Mo</title>
    <link rel="stylesheet" href="../css/login.css">
    <script>
        function submitForm() {
            document.getElementById('loginForm').submit();
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="box box-one">
            <i class="fab fa-twitter"><img src="https://img.icons8.com/color/50/000000/twitter--v1.png"/></i>
        </div>
        <div class="box box-two">
            <form id='loginForm' method='post' action="/login">
            	<div>
					<input type='text' name='username' value='honto23@naver.com'>
				</div>
				<div>
					<input type='password' name='password' value='111111'>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			
            <button class="next-btn" onclick="submitForm()">Next</button>
            <button>Forget password</button>
        </div>
        <p>Don't have an account? <a href="/Albatross/register">Sign Up</a></p>
    </div>
</body>
</html>