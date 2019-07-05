package ihm;

import util.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuOption> options;

    public Menu() {
        options = new ArrayList<>();
        options.add(new ListerChocolatines());
        options.add(new CreerChocolatine());
        options.add(new CréerCommande());
    }

    public void run() {
        Scanner scanner = Constantes.SCANNER;

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
