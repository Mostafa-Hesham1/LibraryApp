/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Loan;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Mostafa
 */
@Stateless
public class LoanManager implements LoanManagerLocal {
  @PersistenceContext(unitName = "LibraryPU")
    private EntityManager em;

    @Override
    public void addLoan(Loan loan) {
        em.persist(loan);
    }

    @Override
    public Loan findLoanById(int id) {
        return em.find(Loan.class, id);
    }

    @Override
    public List<Loan> getAllLoans() {
        return em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
    }
}