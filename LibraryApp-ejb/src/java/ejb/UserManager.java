package ejb;

import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Mostafa
 */
@Stateless
public class UserManager implements UserManagerLocal {

    @PersistenceContext(unitName = "LibraryPU")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUserByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                     .setParameter("username", username)
                     .getSingleResult();
        } catch (Exception e) {
            return null; // Handle the exception or return null if user not found
        }
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void refresh(User user) {
        em.refresh(user);
    }
}
