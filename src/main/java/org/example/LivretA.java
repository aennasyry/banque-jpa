package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("L")
public class LivretA extends Compte{

    @Column
   private double taux;


    public LivretA(){}

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
