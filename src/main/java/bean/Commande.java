package bean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "commande_com")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private int id;

    @Column(name = "com_date_heure")
    private LocalDateTime dateHeure;

    @Column(name = "com_statut")
    private Statut statut;

    @OneToMany(
            mappedBy = "commande",
            cascade = CascadeType.ALL
    )
    private List<CommandeItem> contenu;

    public enum Statut {
        EN_TRAITEMENT,
        EN_LIVRAISON,
        LIVREE;
    }

    public Commande() {
    }

    public Commande(LocalDateTime dateHeure, Statut statut) {
        this.dateHeure = dateHeure;
        this.statut = statut;
        contenu = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public List<CommandeItem> getContenu() {
        return contenu;
    }

    public void setContenu(List<CommandeItem> contenu) {
        this.contenu = contenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id == commande.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commande{");
        sb.append("id=").append(id);
        sb.append(", dateHeure=").append(dateHeure);
        sb.append(", statut=").append(statut);
        sb.append('}');
        return sb.toString();
    }

    public void addItem(Chocolatine c, int nb) {
        CommandeItem ci = new CommandeItem(nb, c.getPrix(), c, this);
        contenu.add(ci);
    }
}
