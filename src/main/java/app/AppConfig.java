package app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

@Configuration
@ComponentScan({"ihm", "bean", "service"})
public class AppConfig {

    @Bean
    public EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("chocolatine");
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
