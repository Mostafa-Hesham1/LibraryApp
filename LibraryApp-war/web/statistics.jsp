<%-- 
    Document   : statistics
    Created on : Jun 5, 2024, 8:22:13 PM
    Author     : Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library Statistics</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header id="main-header">
        <div class="container">
            <h1>Library Statistics</h1>
        </div>
    </header>
    <div class="statistics-container">
        <p>Total Books: <span>${totalBooks}</span></p>
        <p>Total Users: <span>${totalUsers}</span></p>
        <p>Total Loans: <span>${totalLoans}</span></p>
        <a href="index.html">Back to Home</a>
    </div>
</body>
</html>
