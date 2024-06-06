package libarApplication1;

import entities.Book;
import entities.User;
import entities.Loan;
import ejb.BookManagerLocal;
import ejb.UserManagerLocal;
import ejb.LoanManagerLocal;
import ejb.NotificationManagerLocal;
import ejb.StatisticsManagerLocal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LibraryServlet", urlPatterns = {"/LibraryServlet"})
public class LibraryServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;
    @EJB
    private BookManagerLocal bookManager;
    @EJB
    private LoanManagerLocal loanManager;
    @EJB
    private NotificationManagerLocal notificationManager;
    @EJB
    private StatisticsManagerLocal statisticsManager;

    private static final Logger LOGGER = Logger.getLogger(LibraryServlet.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            switch (action) {
                case "addUser":
                    addUser(request, response, out);
                    break;
                case "addBook":
                    addBook(request, response, out);
                    break;
                case "loanBook":
                    loanBook(request, response, out);
                    break;
                case "viewBooks":
                    viewBooks(request, response);
                    break;
                case "viewUsers":
                    viewUsers(request, response);
                    break;
                case "statistics":
                    viewStatistics(request, response, out);
                    break;
                default:
                    out.println("<h1>Invalid action</h1>");
                    out.println("<a href='index.html'>Back to Home</a>");
                    break;
            }
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User user = new User(username, password, email, role);
        userManager.addUser(user);
        notificationManager.sendNotification("New user added: " + username);

        out.println("<h1>User " + username + " added successfully!</h1>");
        out.println("<a href='index.html'>Back to Home</a>");
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book book = new Book(title, author, isbn);
        bookManager.addBook(book);
        notificationManager.sendNotification("New book added: " + title);

        out.println("<h1>Book " + title + " added successfully!</h1>");
        out.println("<a href='index.html'>Back to Home</a>");
    }

    private void loanBook(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String isbn = request.getParameter("isbn");
        String username = request.getParameter("username");
        int loanPeriod = Integer.parseInt(request.getParameter("loanPeriod"));

        try {
            Book book = bookManager.findBookByIsbn(isbn);
            User user = userManager.findUserByUsername(username);
            if (book != null && user != null) {
                Loan loan = new Loan(user, book, new Date());
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(loan.getLoanDate());
                cal.add(java.util.Calendar.DAY_OF_MONTH, loanPeriod);
                loan.setReturnDate(cal.getTime());
                loanManager.addLoan(loan);

                // Refresh user data
                user = userManager.findUserByUsername(username);

                out.println("<h1>Book " + book.getTitle() + " loaned to " + user.getUsername() + " for " + loanPeriod + " days successfully!</h1>");
            } else {
                out.println("<h1>Failed to loan the book. User or Book not found.</h1>");
            }
            out.println("<a href='index.html'>Back to Home</a>");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Invalid loan period", e);
            out.println("<h1>Invalid loan period</h1>");
            out.println("<a href='index.html'>Back to Home</a>");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loaning book", e);
            out.println("<h1>Error loaning book</h1>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
            out.println("<a href='index.html'>Back to Home</a>");
        }
    }

    private void viewBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Book> books = bookManager.getAllBooks();
            request.setAttribute("books", books);
            request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            LOGGER.log(Level.SEVERE, "Error viewing books", e);
            throw e;
        }
    }

    private void viewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = userManager.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            LOGGER.log(Level.SEVERE, "Error viewing users", e);
            throw e;
        }
    }

    private void viewStatistics(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        int totalBooks = statisticsManager.getTotalBooks();
        int totalUsers = statisticsManager.getTotalUsers();
        int totalLoans = statisticsManager.getTotalLoans();
        out.println("<h1>Library Statistics</h1>");
        out.println("<p>Total Books: " + totalBooks + "</p>");
        out.println("<p>Total Users: " + totalUsers + "</p>");
        out.println("<p>Total Loans: " + totalLoans + "</p>");
        out.println("<a href='index.html'>Back to Home</a>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "LibraryServlet";
    }
}
