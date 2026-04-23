/**
 * Classe Produit
 * 
 * Représente un produit agricole avec ses propriétés :
 * - Identifiant unique
 * - Nom du produit
 * - Prix
 * - Quantité disponible
 * - Catégorie
 * 
 * @author AgriGo Team
 * @version 1.0
 */
public class Produit {
    private int idProduit;
    private String nom;
    private double prix;
    private int quantite;
    private String categorie;

    /**
     * Constructeur de la classe Produit
     * 
     * @param idProduit Identifiant unique du produit
     * @param nom Nom du produit
     * @param prix Prix du produit
     * @param quantite Quantité disponible
     * @param categorie Catégorie du produit
     */
    public Produit(int idProduit, String nom, double prix, int quantite, String categorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }

    // ==================== GETTERS ====================

    /**
     * Retourne l'identifiant du produit
     * @return idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * Retourne le nom du produit
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prix du produit
     * @return prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Retourne la quantité du produit
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Retourne la catégorie du produit
     * @return categorie
     */
    public String getCategorie() {
        return categorie;
    }

    // ==================== SETTERS ====================

    /**
     * Définit le nom du produit
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prix du produit
     * @param prix Nouveau prix (doit être >= 0)
     */
    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        }
    }

    /**
     * Définit la quantité du produit
     * @param quantite Nouvelle quantité (doit être >= 0)
     */
    public void setQuantite(int quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }

    /**
     * Définit la catégorie du produit
     * @param categorie Nouvelle catégorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    // ==================== MÉTHODES ====================

    /**
     * Retourne une représentation textuelle du produit
     * @return String représentation du produit
     */
    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    // ==================== TESTS ====================

    /**
     * Méthode main pour tester la classe Produit
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        System.out.println("========== TEST DE LA CLASSE PRODUIT ==========\n");

        // Test 1 : Création d'un produit
        Produit p1 = new Produit(1, "Tomate", 2.50, 100, "Légumes");
        System.out.println("Produit créé : " + p1);

        // Test 2 : Test des getters
        System.out.println("\nTests des getters :");
        System.out.println("  ID         : " + p1.getIdProduit());
        System.out.println("  Nom        : " + p1.getNom());
        System.out.println("  Prix       : " + p1.getPrix() + " €");
        System.out.println("  Quantité   : " + p1.getQuantite());
        System.out.println("  Catégorie  : " + p1.getCategorie());

        // Test 3 : Test des setters
        System.out.println("\nModification du produit :");
        p1.setNom("Tomate Bio");
        p1.setPrix(3.50);
        p1.setQuantite(150);
        p1.setCategorie("Légumes Bio");
        System.out.println("  Produit modifié : " + p1);

        // Test 4 : Création de plusieurs produits
        System.out.println("\nCréation de plusieurs produits :");
        Produit p2 = new Produit(2, "Pomme", 1.20, 200, "Fruits");
        Produit p3 = new Produit(3, "Carotte", 0.80, 300, "Légumes");
        System.out.println("  " + p2);
        System.out.println("  " + p3);

        System.out.println("\n============================================\n");
    }
}