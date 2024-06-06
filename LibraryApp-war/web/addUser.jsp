<%-- 
    Document   : addUser
    Created on : Jun 5, 2024, 8:21:15 PM
    Author     : Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">

        <title>Add User</title>
    </head>
    <body>
        <h1>Add a New User</h1>
        <form method="post" action="LibraryServlet">
            <input type="hidden" name="action" value="addUser"/>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
            <label for="role">Role:</label>
            <input type="text" id="role" name="role" required><br><br>
            <button type="submit">Add User</button>
        </form>
        <a href="index.html">Back to Home</a>
    </body>
</html>

