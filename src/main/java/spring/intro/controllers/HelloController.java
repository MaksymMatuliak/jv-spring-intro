package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.intro.model.User;
import spring.intro.model.dto.UserResponseDto;
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
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> usersResponseDto = new ArrayList<>();
        for (User user : userService.listUsers()) {
            usersResponseDto.add(convertUserIntoUserResponseDto(user));
        }
        return usersResponseDto;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long id) {
        return convertUserIntoUserResponseDto(userService.get(id));
    }

    @ResponseBody
    @GetMapping("/user/inject")
    public void inject() {
        User user1 = new User();
        user1.setName("Maks");
        user1.setPassword("122");
        User user2 = new User();
        user2.setName("Andriy");
        user2.setPassword("tr");
        userService.add(user1);
        userService.add(user2);
    }

    private UserResponseDto convertUserIntoUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
}
