package ejb;

import entities.User;
import jakarta.ejb.Local;
import java.util.List;

/**
 * @author Mostafa
 */
@Local
public interface UserManagerLocal {
     void addUser(User user);
    User findUserByUsername(String username);
    List<User> getAllUsers();
    void refresh(User user);
}
