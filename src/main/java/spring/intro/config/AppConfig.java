package spring.intro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "spring.intro.service.impl",
        "spring.intro.dao.impl"
})
public class AppConfig {
}
