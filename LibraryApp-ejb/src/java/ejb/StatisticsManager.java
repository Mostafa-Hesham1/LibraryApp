/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Book;
import entities.Loan;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Mostafa
 */
@Stateless
public class StatisticsManager implements StatisticsManagerLocal {

    @PersistenceContext(unitName = "LibraryPU")
    private EntityManager em;

    @Override
    public int getTotalBooks() {
        return ((Number) em.createQuery("SELECT COUNT(b) FROM Book b").getSingleResult()).intValue();
    }

    @Override
    public int getTotalUsers() {
        return ((Number) em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult()).intValue();
    }

    @Override
    public int getTotalLoans() {
        return ((Number) em.createQuery("SELECT COUNT(l) FROM Loan l").getSingleResult()).intValue();
    }
}