package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User userMaks = new User();
        userMaks.setName("Maks");
        userMaks.setPassword("1233");
        userService.add(userMaks);
        for (User user : userService.listUsers()) {
            System.out.println(user.toString());
        }
    }
}
