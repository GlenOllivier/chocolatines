package ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class Menu {
    @Autowired
    private Scanner scanner;

    @Autowired
    ListerChocolatines listerChocolatines;
    @Autowired
    CreerChocolatine creerChocolatine;
    @Autowired
    CréerCommande créerCommande;

    private List<MenuOption> options;

    public Menu() {
    }

    @PostConstruct
    public void init() {
        options = new ArrayList<>();
        options.add(listerChocolatines);
        options.add(creerChocolatine);
        options.add(créerCommande);
    }

    public void run() {

        int choix;
        do {
            System.out.println();
            System.out.println("------ Chez Glen ------");
            System.out.println("Veuillez faire un choix");
            for(int i = 0; i < options.size(); i++) {
                System.out.println(i + ". " + options.get(i).getName());
            }
            System.out.println(options.size() + ". " + "Quitter");

            choix = scanner.nextInt();

            if (choix >= 0 && choix < options.size()) {
                options.get(choix).run();
            }

            if (choix > options.size()) {
                System.out.println("Choix inconnu, veuillez recommencer");
            }

        }while (choix != options.size());
    }
}
