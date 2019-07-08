package service;

import bean.Chocolatine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class ChocolatineService {
    @Autowired
    private EntityManagerFactory emf;

    private List<Chocolatine> chocolatines;

    public ChocolatineService() {
    }

    @PostConstruct
    public void init() {

        EntityManager em = emf.createEntityManager();
        chocolatines = em.createQuery("from Chocolatine", Chocolatine.class).getResultList();
        em.close();
    }

    public List<Chocolatine> getChocolatines() {
        return chocolatines;
    }

    public Chocolatine addChocolatine(String nom, float prix, float temperature, float poids) {
        Chocolatine c = new Chocolatine(nom, prix, temperature, poids);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        chocolatines.add(c);
        return c;
    }
}
