package ihm;

import bean.Chocolatine;
import bean.Commande;
import util.Constantes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CréerCommande implements MenuOption {

    @Override
    public String getName() {
        return "Créer une commande";
    }

    @Override
    public void run() {
        List<Chocolatine> liste = Constantes.CHOCOLATINE_SERVICE.getChocolatines();
        System.out.println("Creation de commande");
        Scanner scanner = Constantes.SCANNER;
        Commande commande = new Commande(LocalDateTime.now(), Commande.Statut.EN_TRAITEMENT);
        int choix;
        do {
            System.out.println("Veuillez faire un choix :");
            System.out.println("0 : Afficher les chocolatines");
            System.out.println("1 - " + liste.size() + " : Choisir une chocolatine");
            System.out.println((liste.size() + 1) + " : Valider la commande" );
            System.out.println((liste.size() + 2) + " : Annuler la commande" );
            choix = scanner.nextInt();
            if (choix == 0) {
                for(int i = 0; i < liste.size(); i++) {
                    System.out.println((i+1) + " : " + liste.get(i));
                }
            }
            if (choix > 0 && choix <= liste.size()) {
                choix --;
                System.out.println("Vous avez choisis " + liste.get(choix));
                System.out.println("Combien en ajouter ?");
                int nb = scanner.nextInt();
                commande.addItem(liste.get(choix), nb);
            }

            if(choix == liste.size() + 1) {
                Constantes.COMMANDE_SERVICE.save(commande);
                break;
            }
            if(choix == liste.size() + 2) {
                break;
            }
        }while(true);

    }
}
