import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== 🌱 AgriGo – Sprint 1 ===\n");

        // === Création des utilisateurs ===
        Client client = new Client(101, "Ali", "ali@example.com", "1234");
        Agriculteur agriculteur = new Agriculteur(201, "Sara", "sara@example.com", "1234");
        Admin admin = new Admin(301, "Admin", "admin@example.com", "admin");

        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(client);
        utilisateurs.add(agriculteur);
        utilisateurs.add(admin);

        // === Authentification ===
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== AUTHENTIFICATION ===");
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();

        Utilisateur user = null;
        for (Utilisateur u : utilisateurs) {
            if (u.getEmail().equals(email) && u.getMotDePasse().equals(mdp)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("❌ Échec de connexion");
            return;
        }

        System.out.println("✅ Bienvenue " + user.getNom() + "\n");

        // === Catalogue & Produits ===
        Catalogue catalogue = new Catalogue();
        GestionProduit gestion = new GestionProduit(catalogue);

        Produit p1 = new Produit(1, "Tomate", 2.5, 100);
        Produit p2 = new Produit(2, "Courgette", 3.0, 50);

        gestion.ajouterProduit(p1);
        gestion.ajouterProduit(p2);

        System.out.println("📦 Catalogue :");
        catalogue.afficherCatalogue();

        // === Recherche ===
        client.rechercherProduit(catalogue, "Tomate");

        // === Commande ===
        System.out.println("\n🛒 Commande...");
        Commande commande = new Commande(1, LocalDate.now());
        commande.ajouterLigne(new LigneCommande(p1, 5));
        commande.ajouterLigne(new LigneCommande(p2, 2));
        commande.calculerTotal();

        // === Livraison ===
        Livraison livraison = new Livraison("Préparée");
        System.out.println(livraison);
        livraison.mettreAJourStatut("En cours");
        System.out.println(livraison);

        // === Admin ===
        System.out.println("\n📊 Admin :");
        List<Commande> commandes = new ArrayList<>();
        commandes.add(commande);
        admin.consulterStatistiques(catalogue, commandes);

        scanner.close();
    }
}