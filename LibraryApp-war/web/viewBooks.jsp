<%-- 
    Document   : viewBooks
    Created on : Jun 5, 2024, 8:21:42 PM
    Author     : Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Book"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>View Books</title>
    </head>
    <body>
        <h1>List of Books</h1>
        <ul>
            <%
                List<Book> books = (List<Book>) request.getAttribute("books");
                if (books != null) {
                    for (Book book : books) {
                        out.println("<li>" + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                        out.println("<form method='get' action='loanBook.jsp'>");
                        out.println("<input type='hidden' name='isbn' value='" + book.getIsbn() + "'/>");
                        out.println("<button type='submit'>Loan Book</button>");
                        out.println("</form>");
                        out.println("</li>");
                    }
                } else {
                    out.println("<li>No books found.</li>");
                }
            %>
        </ul>
        <a href="index.html">Back to Home</a>
    </body>
</html>
