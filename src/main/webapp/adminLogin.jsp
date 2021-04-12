
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form class="login" action="AdminLoginServlet" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to Log in</p>
        <hr>

        <input type="text" class="register-input" name="name" required="required" placeholder="name">

        <input type="password" class="register-input" name="password" required="required" placeholder="password">

        <hr>

        <button type="submit" class="registerbtn">Login</button>
    </div>

</form>
</body>
</html>
