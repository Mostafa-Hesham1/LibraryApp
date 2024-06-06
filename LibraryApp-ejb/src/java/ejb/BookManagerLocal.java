/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;
import entities.Book;
import java.util.List;

import jakarta.ejb.Local;

/**
 *
 * @author Mostafa
 */
@Local
public interface BookManagerLocal {
    void addBook(Book book);
    Book findBookByIsbn(String isbn);
    List<Book> getAllBooks();
}
