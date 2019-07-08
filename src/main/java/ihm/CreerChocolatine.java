package ihm;

import bean.Chocolatine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ChocolatineService;

import java.util.Scanner;

@Controller
public class CreerChocolatine implements MenuOption {
    @Autowired
    private ChocolatineService chocolatineService;
    @Autowired
    private Scanner scanner;

    @Override
    public String getName() {
        return "Créer une chocolatine";
    }

    @Override
    public void run() {
        scanner.nextLine();
        System.out.println("Veuillez saisir un nom :");
        String nom = scanner.nextLine();
        System.out.println("Veuillez saisir un prix (€) :");
        float prix = scanner.nextFloat();
        System.out.println("Veuillez saisir une température (°C) :");
        float temperature = scanner.nextFloat();
        System.out.println("Veuillez saisir un poids (Kg) :");
        float poids = scanner.nextFloat();

        Chocolatine c = chocolatineService.addChocolatine(nom, prix, temperature, poids);
        System.out.println(c);
    }
}
