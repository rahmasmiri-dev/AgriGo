import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private static int compteurId = 1;
    private static List<Utilisateur> utilisateurs = new ArrayList<>();
    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    // Constructeur par défaut
    public Utilisateur() {
        this.id = compteurId++;
    }

    // Constructeur avec paramètres
    public Utilisateur(String nom, String email, String motDePasse) {
        this.id = compteurId++;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Constructeur avec id explicite
    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    // Méthode d'inscription : enregistre un nouvel utilisateur si l'email n'existe pas
    public static boolean sInscrire(String nom, String email, String motDePasse) {
        // Vérifier si l'email existe déjà
        for (Utilisateur u : utilisateurs) {
            if (u.email != null && u.email.equals(email)) {
                System.out.println("Erreur : Un utilisateur avec cet email existe déjà.");
                return false;
            }
        }
        // Créer et ajouter le nouvel utilisateur
        Utilisateur nouveau = new Utilisateur(nom, email, motDePasse);
        utilisateurs.add(nouveau);
        System.out.println("Utilisateur inscrit avec succès : " + nom + " (ID: " + nouveau.id + ")");
        return true;
    }

    // Méthode d'authentification : vérifie les identifiants et retourne l'utilisateur si réussi
    public static Utilisateur sAuthentifier(String email, String motDePasse) {
        for (Utilisateur u : utilisateurs) {
            if (u.email != null && u.email.equals(email) && u.motDePasse != null && u.motDePasse.equals(motDePasse)) {
                System.out.println("Authentification réussie pour " + u.nom);
                return u;
            }
        }
        System.out.println("Échec de l'authentification : identifiants incorrects");
        return null;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', email='" + email + "'}";
    }

    // Méthode main pour tester
    public static void main(String[] args) {
        // Test d'inscription
        sInscrire("Alice Dupont", "alice@example.com", "motdepasse123");
        sInscrire("Bob Martin", "bob@example.com", "password456");

        // Test d'inscription avec email existant
        sInscrire("Charlie", "alice@example.com", "autremotdepasse");

        // Test d'authentification réussie
        Utilisateur user = sAuthentifier("alice@example.com", "motdepasse123");
        if (user != null) {
            System.out.println("Utilisateur connecté : " + user);
        }

        // Test d'authentification échouée
        sAuthentifier("alice@example.com", "mauvaismotdepasse");

        // Test d'authentification avec email inexistant
        sAuthentifier("inexistant@example.com", "password");
    }
}