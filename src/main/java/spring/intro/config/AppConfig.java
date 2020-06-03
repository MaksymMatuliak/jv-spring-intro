package spring.intro.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import spring.intro.model.User;

@Configuration
@ComponentScan(basePackages = {
        "spring.intro.service.impl",
        "spring.intro.dao.impl"
})
public class AppConfig {
    @Bean
    public DataSource getDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/spring_intro?serverTimezone=UTC");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setAnnotatedClasses(User.class);
        return localSessionFactoryBean;
    }
}
