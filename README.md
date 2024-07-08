# Library Management System

## Description

This project implements a library management system using Enterprise JavaBeans (EJB) for backend services and a servlet for handling HTTP requests. The system manages books, users, loans, and provides statistics functionalities.

## EJB Components

### BookManager

- **Description:** Manages CRUD operations for books.
- **Methods:**
  - `void addBook(Book book)`: Adds a new book to the database.
  - `Book findBookByIsbn(String isbn)`: Retrieves a book by ISBN.
  - `List<Book> getAllBooks()`: Retrieves all books from the database.

### LoanManager

- **Description:** Manages CRUD operations for loans.
- **Methods:**
  - `void addLoan(Loan loan)`: Adds a new loan to the database.
  - `Loan findLoanById(int id)`: Retrieves a loan by ID.
  - `List<Loan> getAllLoans()`: Retrieves all loans from the database.

### NotificationManager

- **Description:** Handles notification logic.
- **Methods:**
  - `void sendNotification(String message)`: Sends notifications (e.g., email, SMS).

### StatisticsManager

- **Description:** Provides statistics about books, users, and loans.
- **Methods:**
  - `int getTotalBooks()`: Retrieves the total number of books.
  - `int getTotalUsers()`: Retrieves the total number of users.
  - `int getTotalLoans()`: Retrieves the total number of loans.

### UserManager

- **Description:** Manages CRUD operations for users.
- **Methods:**
  - `void addUser(User user)`: Adds a new user to the database.
  - `User findUserByUsername(String username)`: Retrieves a user by username.
  - `List<User> getAllUsers()`: Retrieves all users from the database.
  - `void refresh(User user)`: Refreshes a user entity from the database.

## Servlet

### LibraryServlet

- **Description:** Handles HTTP requests for user interaction with the library system.
- **Actions:**
  - `addUser`: Adds a new user.
  - `addBook`: Adds a new book.
  - `loanBook`: Processes a book loan to a user.
  - `viewBooks`: Displays all books.
  - `viewUsers`: Displays all users.
  - `statistics`: Displays library statistics (total books, users, loans).

## How to Run

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/library-management.git
####Import the project into your IDE (e.g., NetBeans, IntelliJ IDEA).

####Configure the database connection in persistence.xml (unit name: LibraryPU).

####Build and deploy the project to a Java EE application server (e.g., WildFly, GlassFish).

####Access the application through the servlet endpoints (e.g., http://localhost:8080/LibraryServlet).

##Technologies Used
###Java EE
###Enterprise JavaBeans (EJB)
###Servlet
###Java Persistence API (JPA)
###Jakarta EE
###HTML/CSS for front-end views
###Dependencies
###jakarta.ejb
###jakarta.persistence
###jakarta.servlet
###javax.annotation 
