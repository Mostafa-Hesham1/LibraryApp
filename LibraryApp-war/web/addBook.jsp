<%-- 
    Document   : addBook
    Created on : Jun 5, 2024, 8:20:41 PM
    Author     : Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">

        <title>Add Book</title>
        
    </head>
    <body>
        <h1>Add a New Book</h1>
        <form method="post" action="LibraryServlet">
            <input type="hidden" name="action" value="addBook"/>
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required><br><br>
            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required><br><br>
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" required><br><br>
            <button type="submit">Add Book</button>
        </form>
        <a href="index.html">Back to Home</a>
    </body>
</html>
