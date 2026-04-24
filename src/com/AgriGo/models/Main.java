package com.AgriGo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AgriGo – Sprint 2 ===\n");

        // === UTILISATEURS ===
        Client client = new Client(1, "Ali", "ali@mail.com", "123456");
        Agriculteur agriculteur = new Agriculteur(2, "Sara", "sara@mail.com", "123456");
        Admin admin = new Admin(3, "Admin", "admin@mail.com", "admin");

        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(client);
        utilisateurs.add(agriculteur);
        utilisateurs.add(admin);

        // === AUTHENTIFICATION ===
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String mdp = scanner.nextLine();

        Utilisateur user = Utilisateur.sAuthentifier(email, mdp);

        if (user == null) {
            System.out.println("❌ Échec de connexion");
            return;
        }

        System.out.println("✅ Bienvenue " + user.getNom());

        // === GESTION PRODUITS ===
        GestionProduit gestion = new GestionProduit();

        gestion.ajouter("Tomate", 2.5, 100, "Légume");
        gestion.ajouter("Pomme", 1.8, 150, "Fruit");

        // === ROLE AGRICULTEUR ===
        if (user instanceof Agriculteur) {
            System.out.println("\n=== AGRICULTEUR ===");

            gestion.afficher();

            gestion.modifierPrix(1, 3.0);
            gestion.modifierQuantite(2, 200);

            gestion.supprimer(1);

            System.out.println("\nAprès modification :");
            gestion.afficher();
        }

        // === ROLE CLIENT ===
        if (user instanceof Client) {
            System.out.println("\n=== CLIENT ===");

            gestion.afficher();

            Commande commande = new Commande(1001, LocalDate.now());

            Produit p = gestion.getListeProduits().get(0);

            commande.ajouterLigne(new LigneCommande(p, 5));
            commande.calculerTotal();

            Livraison livraison = new Livraison("Préparée");
            livraison.mettreAJourStatut("En cours");

            System.out.println(livraison);
        }

        // === ROLE ADMIN ===
        if (user instanceof Admin) {
            System.out.println("\n=== ADMIN ===");

            admin.gererUtilisateurs(utilisateurs);

            List<Commande> commandes = new ArrayList<>();
            commandes.add(new Commande(1001, LocalDate.now()));

            admin.consulterStatistiques(null, commandes);
        }

        System.out.println("\n=== FIN SPRINT 2 ===");
        scanner.close();
    }
}