/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import jakarta.ejb.Stateless;

/**
 *
 * @author Mostafa
 */
@Stateless
public class NotificationManager implements NotificationManagerLocal {

     @Override
    public void sendNotification(String message) {
        // Implement notification logic, e.g., email, SMS, etc.
        System.out.println("Notification sent: " + message);
    }
}