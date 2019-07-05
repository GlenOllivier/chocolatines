package bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "chocolatine_cho")
public class Chocolatine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cho_id")
    private int id;

    @Column(name = "cho_nom")
    private String nom;

    @Column(name = "cho_prix")
    private float prix;

    @Column(name = "cho_temperature")
    private float temperature;

    @Column(name = "cho_poids")
    private float poids;

    public Chocolatine() {
    }

    public Chocolatine(String nom, float prix, float temperature, float poids) {
        this.nom = nom;
        this.prix = prix;
        this.temperature = temperature;
        this.poids = poids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chocolatine that = (Chocolatine) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chocolatine{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prix=").append(prix);
        sb.append(", temperature=").append(temperature);
        sb.append(", poids=").append(poids);
        sb.append('}');
        return sb.toString();
    }
}
