package spring.intro.service;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.intro.model.User;

@Service
public interface UserService {
    void add(User user);

    List<User> listUsers();
}
