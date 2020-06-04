package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.UserResponseDto;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        UserResponseDto userResponseDtoMaks = new UserResponseDto();
        userResponseDtoMaks.setName("Maks");
        userResponseDtoMaks.setPassword("1233");
        userService.add(userResponseDtoMaks);
        for (UserResponseDto userResponseDto : userService.listUsers()) {
            System.out.println(userResponseDto.toString());
        }
        context.close();
    }
}
