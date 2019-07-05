package util;

import service.ChocolatineService;
import service.CommandeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public abstract class Constantes {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("chocolatine");
    public static final ChocolatineService CHOCOLATINE_SERVICE = new ChocolatineService();
    public static final CommandeService COMMANDE_SERVICE = new CommandeService();

    public static EntityManager newEntityManager() {
        return EMF.createEntityManager();
    }
}
