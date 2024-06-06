<%-- 
    Document   : loanBook
    Created on : Jun 5, 2024, 11:21:01 PM
    Author     : Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Loan Book</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header id="main-header">
        <div class="container">
            <h1>Loan a Book</h1>
        </div>
    </header>
    <div id="main" class="container">
        <form method="post" action="LibraryServlet">
            <input type="hidden" name="action" value="loanBook"/>
            <label for="isbn">Book ISBN:</label>
            <input type="text" id="isbn" name="isbn" required><br><br>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="loanPeriod">Loan Period (days):</label>
            <input type="number" id="loanPeriod" name="loanPeriod" required><br><br>
            <button type="submit">Loan Book</button>
        </form>
        <a href="index.html">Back to Home</a>
    </div>
</body>
</html>
