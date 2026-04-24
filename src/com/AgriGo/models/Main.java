import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // === EXEMPLE DE SPRINT 1 AGRIGO ===
        System.out.println("=== AgriGo – Sprint 1 ===\n");

        // Inscription
        System.out.println("--- Inscription (Ali) ---");
        System.out.println("Nouvel utilisateur inscrit : Ali (ali@example.com)\n");

        // Authentification
        System.out.println("--- Authentification (Ali) ---");
        System.out.println("Utilisateur créé : Ali (ali@example.com)");
        System.out.println("Connexion réussie !\n");

        // Gestion Produits & Catalogue
        System.out.println("--- Gestion Produits & Catalogue (Sara) ---");
        System.out.println("Produit ajouté : Tomate, 2.5 DT, 100 unités");
        System.out.println("Produit ajouté : Courgette, 3.0 DT, 50 unités");
        System.out.println("Catalogue actuel : Tomate, Courgette, Pomme de terre, Carotte\n");

        // Commande & Livraison
        System.out.println("--- Commande & Livraison (Ali) ---");
        System.out.println("Commande créée : 2x Courgette, 5x Tomate");
        System.out.println("Total commande : 21.0 DT");
        System.out.println("Livraison : Préparée → En cours de livraison\n");

        // Admin
        System.out.println("--- Admin (Admin) ---");
        System.out.println("Nombre d'utilisateurs : 3");
        System.out.println("Nombre de commandes : 1\n");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Création des utilisateurs
        Client client = new Client(101, "Ali", "ali@example.com", "motdepasse");
        Agriculteur agriculteur = new Agriculteur(201, "Sara", "sara@example.com", "password");
        Admin admin = new Admin(301, "Admin", "admin@example.com", "admin123");

        java.util.List<Utilisateur> utilisateurs = new java.util.ArrayList<>();
        utilisateurs.add(client);
        utilisateurs.add(agriculteur);
        utilisateurs.add(admin);

        // === AUTHENTIFICATION ===
        System.out.println("=== AUTHENTIFICATION ===");
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        Utilisateur utilisateurConnecte = null;
        for (Utilisateur u : utilisateurs) {
            if (u.sAuthentifier(email, motDePasse)) {
                utilisateurConnecte = u;
                break;
            }
        }

        if (utilisateurConnecte == null) {
            System.out.println("Échec de l'authentification. Email ou mot de passe incorrect.");
            scanner.close();
            return;
        } else {
            System.out.println("Bienvenue, " + utilisateurConnecte.getNom() + "!\n");
        }

        Catalogue catalogue = new Catalogue();
        GestionProduitsEtCatalogue gestion = new GestionProduitsEtCatalogue(catalogue);

        // === CRÉATION ET AJOUT DE PRODUITS ===
        System.out.println("=== GESTION DES PRODUITS ===\n");

        Produit tomate = new Produit(1, "Tomate", 2.5, 100);
        Produit courgette = new Produit(2, "Courgette", 3.0, 50);
        Produit pommeDeTerre = new Produit(3, "Pomme de terre", 1.8, 200);
        Produit carotte = new Produit(4, "Carotte", 2.2, 80);

        gestion.ajouterProduit(tomate);
        gestion.ajouterProduit(courgette);
        gestion.ajouterProduit(pommeDeTerre);
        gestion.ajouterProduit(carotte);
        System.out.println();

        // === AFFICHAGE DU CATALOGUE ===
        System.out.println("Catalogue actuel :");
        catalogue.afficherCatalogue();
        System.out.println();

        // === MODIFICATION DE PRODUITS ===
        System.out.println("=== MODIFICATIONS ===\n");
        gestion.modifierNomProduit(courgette, "Courgette bio");
        gestion.modifierPrixProduit(tomate, 3.0);
        gestion.modifierQuantiteProduit(pommeDeTerre, 150);
        gestion.modifierProduit(carotte, "Carotte orange", 2.5, 120);
        System.out.println();

        // === AFFICHAGE APRÈS MODIFICATION ===
        System.out.println("Catalogue après modification :");
        catalogue.afficherCatalogue();
        System.out.println();

        // === SUPPRESSION DE PRODUITS ===
        System.out.println("=== SUPPRESSION ===\n");
        gestion.supprimerProduit(pommeDeTerre);
        System.out.println();

        // === AFFICHAGE FINAL ===
        System.out.println("Catalogue final :");
        catalogue.afficherCatalogue();
        System.out.println();

        // === UTILISATION AVEC LES AUTRES CLASSES ===
        System.out.println("=== UTILISATION AVEC AUTRES CLASSES ===\n");
        
        client.consulterCatalogue(catalogue);
        client.rechercherProduit(catalogue, "Tomate");
        System.out.println();

        Commande commande = new Commande(5001, LocalDate.now());
        commande.ajouterLigne(new LigneCommande(tomate, 5));
        commande.ajouterLigne(new LigneCommande(courgette, 2));
        commande.calculerTotal();
        System.out.println();

        Livraison livraison = new Livraison("Préparée");
        System.out.println(livraison);
        livraison.mettreAJourStatut("En cours de livraison");
        System.out.println(livraison);
        System.out.println();

        admin.gererUtilisateurs(utilisateurs);
        List<Commande> commandes = new ArrayList<>();
        commandes.add(commande);
        admin.consulterStatistiques(catalogue, commandes);
        scanner.close();
    }
}
