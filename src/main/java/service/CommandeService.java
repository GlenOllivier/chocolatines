package service;

import bean.Commande;
import util.Constantes;

import javax.persistence.EntityManager;
import java.util.List;

public class CommandeService {
    List<Commande> commandes;

    public void save(Commande commande) {
        EntityManager em = Constantes.newEntityManager();
        em.getTransaction().begin();
        em.persist(commande);
        em.getTransaction().commit();
        em.close();
    }
}
