package spring.intro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.intro.model.User;
import spring.intro.service.UserService;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public User sayHello() {
        User user = new User();
        user.setName("Maks");
        return user;
    }

    @ResponseBody
    @GetMapping("/user/")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @ResponseBody
    @GetMapping("/user/inject")
    public void inject() {
        User user1 = new User();
        user1.setName("Maks");
        User user2 = new User();
        user2.setName("Andriy");
        userService.add(user1);
        userService.add(user2);
    }
}
