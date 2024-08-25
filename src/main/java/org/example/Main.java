package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();


            Banque banque = new Banque();
            banque.setNom("Banque Centrale");

            Client client = new Client();
            client.setNom("Shishnak");
            client.setPrenom("Soufiane");
            client.setAdresse(new Adresse( 5, "nakhi","30000"));

            Compte compte = new Compte();
            compte.setNumero("11111111111");
            compte.setSolde(10000);
            Set<Client> c = new HashSet<>();
            c.add(client);
            compte.setClients(c);

            Operation operation = new Operation();
            operation.setDate(new java.util.Date());
            operation.setMontant(150);
            operation.setCompte(compte);




            em.persist(banque);
            em.persist(client);
            em.persist(compte);
            em.persist(operation);

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}