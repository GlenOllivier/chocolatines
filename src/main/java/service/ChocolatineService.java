package service;

import bean.Chocolatine;
import util.Constantes;

import javax.persistence.EntityManager;
import java.util.List;

public class ChocolatineService {

    private List<Chocolatine> chocolatines;

    public ChocolatineService() {

        EntityManager em = Constantes.newEntityManager();
        chocolatines = em.createQuery("from Chocolatine", Chocolatine.class).getResultList();
        em.close();

    }

    public List<Chocolatine> getChocolatines() {
        return chocolatines;
    }

    public Chocolatine addChocolatine(String nom, float prix, float temperature, float poids) {
        Chocolatine c = new Chocolatine(nom, prix, temperature, poids);
        EntityManager em = Constantes.newEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        chocolatines.add(c);
        return c;
    }
}
