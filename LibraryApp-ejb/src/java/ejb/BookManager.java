/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author Mostafa
 */
@Stateless
public class BookManager implements BookManagerLocal {

   @PersistenceContext(unitName = "LibraryPU")
    private EntityManager em;

    @Override
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        try {
            return em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class)
                     .setParameter("isbn", isbn)
                     .getSingleResult();
        } catch (Exception e) {
            return null; // Handle the exception or return null if book not found
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}