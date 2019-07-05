package bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "commande_item_cit")
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cit_id")
    private int id;
    @Column(name = "cit_quantite")
    private int quantite;
    @Column(name = "cit_prix_unitaire")
    private float prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "cho_id")
    private Chocolatine chocolatine;
    @ManyToOne
    @JoinColumn(name = "com_id")
    private Commande commande;

    public CommandeItem() {
    }

    public CommandeItem(int quantite, float prixUnitaire, Chocolatine chocolatine, Commande commande) {
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.chocolatine = chocolatine;
        this.commande = commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Chocolatine getChocolatine() {
        return chocolatine;
    }

    public void setChocolatine(Chocolatine chocolatine) {
        this.chocolatine = chocolatine;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandeItem{");
        sb.append("quantite=").append(quantite);
        sb.append(", prixUnitaire=").append(prixUnitaire);
        sb.append(", chocolatine=").append(chocolatine);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeItem that = (CommandeItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
