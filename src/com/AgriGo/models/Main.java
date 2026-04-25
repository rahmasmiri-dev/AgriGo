package com.AgriGo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AgriGo - Sprint 2 ===\n");

        // ================= INSCRIPTION =================
        Utilisateur.sInscrire("Ali", "ali@mail.com", "123456");       // client
        Utilisateur.sInscrire("Sara", "sara@mail.com", "123456");     // agriculteur
        Utilisateur.sInscrire("Admin", "admin@mail.com", "admin");    // admin

        // ================= AUTH =================
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

        // ================= DATA =================
        Catalogue catalogue = new Catalogue();
        GestionProduit gestion = new GestionProduit(catalogue);

        Produit p1 = new Produit(1, "Tomate", 2.5, 100);
        Produit p2 = new Produit(2, "Pomme", 1.8, 150);

        gestion.ajouterProduit(p1);
        gestion.ajouterProduit(p2);

        // ================= CLIENT =================
        if (email.equals("ali@mail.com")) {
            System.out.println("\n=== CLIENT ===");

            catalogue.afficherCatalogue();

            Commande commande = new Commande(1001, LocalDate.now());
            commande.ajouterLigne(new LigneCommande(p1, 5));
            commande.ajouterLigne(new LigneCommande(p2, 2));
            commande.calculerTotal();

            Livraison livraison = new Livraison("Préparée");
            livraison.mettreAJourStatut("En cours");

            System.out.println(livraison de commande);
        }

        // ================= AGRICULTEUR =================
        if (email.equals("sara@mail.com")) {
            System.out.println("\n=== AGRICULTEUR ===");

            catalogue.afficherCatalogue();

            // Modifier
            p1.setPrix(3.0);
            p2.setQuantite(200);

            // Supprimer
            gestion.supprimerProduit(p1);

            System.out.println("\nAprès modification :");
            catalogue.afficherCatalogue();
        }

        // ================= ADMIN =================
        if (email.equals("admin@mail.com")) {
            System.out.println("\n=== ADMIN ===");

            Admin admin = new Admin(3, "Admin", "admin@mail.com", "admin");

            admin.gererUtilisateurs(Utilisateur.getUtilisateurs());

            List<Commande> commandes = new ArrayList<>();
            commandes.add(new Commande(1001, LocalDate.now()));

            admin.consulterStatistiques(catalogue, commandes);
        }

        System.out.println("\n=== FIN ===");
        scanner.close();
    }
}