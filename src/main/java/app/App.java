package app;


import ihm.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AppConfig.class);

        Menu menu = context.getBean(Menu.class);
        menu.run();

        context.close();


    }
}
