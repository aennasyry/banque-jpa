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

            //ajout d'un client à la liste de clients c
            Client client2 = new Client();
            client2.setNom("Shishnak");
            client2.setPrenom("So");
            client2.setAdresse(new Adresse( 7, "nakhi","30000"));
            c.add(client2);

            //Creation d'un compte avec deux clients
            Compte compte2 = new Compte();
            compte2.setNumero("222222222");
            compte2.setSolde(10000);
            compte2.setClients(c);

            //Creation d'un client avec plusieurs compte(LivertA et AssuranceVie)
            LivretA la = new LivretA();
            la.setTaux(0.5);
            la.setSolde(5000);
            la.setNumero("33333333333");

            AssuranceVie as = new AssuranceVie();
            as.setDateFin(new Date());
            as.setSolde(65656);
            as.setNumero("444444444444");
            as.setTaux(2.5);

            Set<Compte> comptes= new HashSet<>();
            comptes.add(la);
            comptes.add(as);
            client.setComptes(comptes);

            //Insersion d'opperation de type virement sur un compte
            Virement virement = new Virement();
            virement.setBeneficiaire("alae");
            virement.setDate(new Date());
            virement.setMontant(2000);
            virement.setCompte(as);

            //Insersion d'opperation de type operation sur un compte
            Operation op = new Operation();
            op.setDate(new Date());
            op.setMontant(20);
            op.setCompte(as);



            em.persist(as);
            em.persist(la);
            em.persist(compte2);
            em.persist(client2);
            em.persist(virement);
            em.persist(operation);
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