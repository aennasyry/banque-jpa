package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class Adresse{
    private Integer numero;
    private String rue;
    private String ville;

    public Adresse(Integer numero, String rue, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
    }
}
