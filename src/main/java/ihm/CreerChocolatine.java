package ihm;

import bean.Chocolatine;
import util.Constantes;

import java.util.Scanner;

public class CreerChocolatine implements MenuOption {
    @Override
    public String getName() {
        return "Créer une chocolatine";
    }

    @Override
    public void run() {
        Scanner scanner = Constantes.SCANNER;
        scanner.nextLine();
        System.out.println("Veuillez saisir un nom :");
        String nom = scanner.nextLine();
        System.out.println("Veuillez saisir un prix (€) :");
        float prix = scanner.nextFloat();
        System.out.println("Veuillez saisir une température (°C) :");
        float temperature = scanner.nextFloat();
        System.out.println("Veuillez saisir un poids (Kg) :");
        float poids = scanner.nextFloat();

        Chocolatine c = Constantes.CHOCOLATINE_SERVICE.addChocolatine(nom, prix, temperature, poids);
        System.out.println(c);
    }
}
