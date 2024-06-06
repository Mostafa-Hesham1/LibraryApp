/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Loan;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Mostafa
 */
@Local
public interface LoanManagerLocal {
    void addLoan(Loan loan);
    Loan findLoanById(int id);
    List<Loan> getAllLoans();
}
