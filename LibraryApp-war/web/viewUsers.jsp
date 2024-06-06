<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.User"%>
<%@page import="entities.Loan"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Users</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <header id="main-header">
            <div class="container">
                <h1>List of Users</h1>
            </div>
        </header>
        <div class="container">
            <ul class="user-list">
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    if (users != null) {
                        for (User user : users) {
                %>
                <li>
                    <h2><%= user.getUsername() %> (Email: <%= user.getEmail() %>)</h2>
                    <ul class="loan-list">
                        <%
                            List<Loan> loans = user.getLoans();
                            if (loans != null) {
                                for (Loan loan : loans) {
                        %>
                        <li>Loaned Book ISBN: <%= loan.getBook().getIsbn() %> (Return Date: <%= loan.getReturnDate() %>)</li>
                        <%
                                }
                            } else {
                        %>
                        <li>No loans found.</li>
                        <%
                            }
                        %>
                    </ul>
                </li>
                <%
                        }
                    } else {
                %>
                <li>No users found.</li>
                <%
                    }
                %>
            </ul>
            <a href="index.html">Back to Home</a>
        </div>
    </body>
</html>
