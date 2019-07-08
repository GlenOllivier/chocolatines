package service;

import bean.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private EntityManagerFactory emf;

    List<Commande> commandes;

    public void save(Commande commande) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(commande);
        em.getTransaction().commit();
        em.close();
    }
}
