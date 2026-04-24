import java.util.List;

public class Admin extends Utilisateur {

    public Admin(int id, String nom, String email, String motDePasse) {
        super(id, nom, email, motDePasse);
    }

    // Afficher les utilisateurs
    public void gererUtilisateurs(List<Utilisateur> utilisateurs) {
        System.out.println("\n📋 Liste des utilisateurs :");
        for (Utilisateur u : utilisateurs) {
            System.out.println("- " + u.getNom() + " (" + u.getEmail() + ")");
        }
    }

    // Statistiques système
    public void consulterStatistiques(Catalogue catalogue, List<Commande> commandes) {
        System.out.println("\n📊 Statistiques :");
        System.out.println("Nombre de produits : " + catalogue.nombreDeProduits());
        System.out.println("Nombre de commandes : " + commandes.size());
    }
}