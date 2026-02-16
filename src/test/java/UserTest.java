import org.example.controler.UserService;
import org.example.exceptions.IsNullException;
import org.example.exceptions.PasswordLengthException;
import org.example.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    public void insertUser(){
        String username = "Adri";
        String password = "12345678";

        UserService userService = new UserService();
        userService.register(username, password);

        assertThat(userService.getUsers()).hasSize(1);
    }

    @Test
    public void userIsNotNull(){
        String username = null;
        String password = "12345678";

        UserService userService = new UserService();


        assertThatThrownBy( () -> userService.register(username, password)).isInstanceOf(IsNullException.class);
    }

    @Test
    public void passwordLessThanEightCharacters(){
        String username = "Adri";
        String password = "12345";

        UserService userService = new UserService();

        assertThatThrownBy( () -> userService.register(username, password)).isInstanceOf(PasswordLengthException.class);
    }

    @Test
    public void userAlreadyExistsInHashMap(){
        String username1 = "Adri";
        String password1 = "12345678";
        String username2 = "Adri";
        String password2 = "87654321";

        UserService userService = new UserService();

        userService.register(username1, password1);

        assertThatThrownBy( () -> userService.register(username2, password2)).isInstanceOf(UserAlreadyExistException.class);
    }
}
