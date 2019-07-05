import bean.Chocolatine;
import bean.Commande;
import bean.CommandeItem;
import ihm.Menu;
import util.Constantes;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.run();



    }
}
