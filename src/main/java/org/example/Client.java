package org.example;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datedenaissance")
    private LocalDate dateDeNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    @ManyToMany
    @JoinTable(name="COMPTE_CLIENT",joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName="ID"),
                                    inverseJoinColumns = @JoinColumn(name = "ID_COMPTE",referencedColumnName = "ID")

    )
    private Set<Compte> comptes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }


}
