package spring.intro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.intro.model.UserResponseDto;
import spring.intro.service.UserService;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public UserResponseDto sayHello() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName("Maks");
        return userResponseDto;
    }

    @ResponseBody
    @GetMapping("/user/")
    public List<UserResponseDto> getUsers() {
        return userService.listUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.get(id);
    }

    @ResponseBody
    @GetMapping("/user/inject")
    public void inject() {
        UserResponseDto userResponseDto1 = new UserResponseDto();
        userResponseDto1.setName("Maks");
        UserResponseDto userResponseDto2 = new UserResponseDto();
        userResponseDto2.setName("Andriy");
        userService.add(userResponseDto1);
        userService.add(userResponseDto2);
    }
}
