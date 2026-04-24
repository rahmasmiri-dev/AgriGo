import java.util.ArrayList;
import java.util.List;

/**
 * Classe GestionProduit
 * 
 * Gère une liste de produits avec les opérations suivantes :
 * - Ajouter un produit
 * - Modifier un produit (tous les champs ou partiellement)
 * - Supprimer un produit
 * - Afficher les produits (tous, par ID, par nom, par catégorie)
 * 
 * @author AgriGo Team
 * @version 1.0
 */
public class GestionProduit {
    private List<Produit> listeProduits;
    private int compteurId;

    /**
     * Constructeur de la classe GestionProduit
     * Initialise une liste vide de produits
     */
    public GestionProduit() {
        this.listeProduits = new ArrayList<>();
        this.compteurId = 1;
    }

    // ==================== AJOUTER ====================

    /**
     * Ajoute un nouveau produit à la liste
     * 
     * @param nom Nom du produit
     * @param prix Prix du produit
     * @param quantite Quantité du produit
     * @param categorie Catégorie du produit
     */
    public void ajouter(String nom, double prix, int quantite, String categorie) {
        if (nom == null || nom.isEmpty()) {
            System.out.println("Erreur : Le nom du produit ne peut pas être vide.");
            return;
        }
        if (prix < 0 || quantite < 0) {
            System.out.println("Erreur : Le prix et la quantité doivent être positifs.");
            return;
        }

        Produit produit = new Produit(compteurId++, nom, prix, quantite, categorie);
        listeProduits.add(produit);
        System.out.println("✓ Produit ajouté avec succès : " + nom);
    }

    // ==================== MODIFIER ====================

    /**
     * Modifie tous les paramètres d'un produit existant
     * 
     * @param idProduit ID du produit à modifier
     * @param nom Nouveau nom (null pour ne pas modifier)
     * @param prix Nouveau prix (< 0 pour ne pas modifier)
     * @param quantite Nouvelle quantité (< 0 pour ne pas modifier)
     * @param categorie Nouvelle catégorie (null pour ne pas modifier)
     */
    public void modifier(int idProduit, String nom, double prix, int quantite, String categorie) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }

        if (nom != null && !nom.isEmpty()) {
            produit.setNom(nom);
        }
        if (prix >= 0) {
            produit.setPrix(prix);
        }
        if (quantite >= 0) {
            produit.setQuantite(quantite);
        }
        if (categorie != null && !categorie.isEmpty()) {
            produit.setCategorie(categorie);
        }

        System.out.println("✓ Produit modifié avec succès.");
    }

    /**
     * Modifie uniquement le nom du produit
     * 
     * @param idProduit ID du produit
     * @param nouveauNom Nouveau nom du produit
     */
    public void modifierNom(int idProduit, String nouveauNom) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }
        if (nouveauNom == null || nouveauNom.isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide.");
            return;
        }

        produit.setNom(nouveauNom);
        System.out.println("✓ Nom du produit modifié en : " + nouveauNom);
    }

    /**
     * Modifie uniquement le prix du produit
     * 
     * @param idProduit ID du produit
     * @param nouveauPrix Nouveau prix du produit
     */
    public void modifierPrix(int idProduit, double nouveauPrix) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }
        if (nouveauPrix < 0) {
            System.out.println("Erreur : Le prix ne peut pas être négatif.");
            return;
        }

        produit.setPrix(nouveauPrix);
        System.out.println("✓ Prix du produit modifié en : " + nouveauPrix);
    }

    /**
     * Modifie uniquement la quantité du produit
     * 
     * @param idProduit ID du produit
     * @param nouvelleQuantite Nouvelle quantité du produit
     */
    public void modifierQuantite(int idProduit, int nouvelleQuantite) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }
        if (nouvelleQuantite < 0) {
            System.out.println("Erreur : La quantité ne peut pas être négative.");
            return;
        }

        produit.setQuantite(nouvelleQuantite);
        System.out.println("✓ Quantité du produit modifiée en : " + nouvelleQuantite);
    }

    // ==================== SUPPRIMER ====================

    /**
     * Supprime un produit de la liste par son ID
     * 
     * @param idProduit ID du produit à supprimer
     */
    public void supprimer(int idProduit) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }

        listeProduits.remove(produit);
        System.out.println("✓ Produit avec l'ID " + idProduit + " supprimé avec succès.");
    }

    // ==================== AFFICHER ====================

    /**
     * Affiche tous les produits de la liste
     */
    public void afficher() {
        if (listeProduits.isEmpty()) {
            System.out.println("Aucun produit dans la liste.");
            return;
        }

        System.out.println("\n========== LISTE DES PRODUITS ==========");
        for (Produit produit : listeProduits) {
            System.out.println(produit);
        }
        System.out.println("========================================\n");
    }

    /**
     * Affiche un produit spécifique par son ID
     * 
     * @param idProduit ID du produit à afficher
     */
    public void afficherProduit(int idProduit) {
        Produit produit = rechercherParId(idProduit);
        if (produit == null) {
            System.out.println("Erreur : Produit avec l'ID " + idProduit + " introuvable.");
            return;
        }

        System.out.println("\nDétails du produit :");
        System.out.println(produit);
    }

    /**
     * Affiche tous les produits ayant un nom spécifique (insensible à la casse)
     * 
     * @param nom Nom du produit à rechercher
     */
    public void afficherParNom(String nom) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : listeProduits) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                resultats.add(produit);
            }
        }

        if (resultats.isEmpty()) {
            System.out.println("Aucun produit trouvé avec le nom : " + nom);
            return;
        }

        System.out.println("\n========== PRODUITS PAR NOM : " + nom + " ==========");
        for (Produit produit : resultats) {
            System.out.println(produit);
        }
        System.out.println("============================================\n");
    }

    /**
     * Affiche tous les produits d'une catégorie spécifique (insensible à la casse)
     * 
     * @param categorie Catégorie à rechercher
     */
    public void afficherParCategorie(String categorie) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : listeProduits) {
            if (produit.getCategorie().equalsIgnoreCase(categorie)) {
                resultats.add(produit);
            }
        }

        if (resultats.isEmpty()) {
            System.out.println("Aucun produit trouvé dans la catégorie : " + categorie);
            return;
        }

        System.out.println("\n========== PRODUITS PAR CATÉGORIE : " + categorie + " ==========");
        for (Produit produit : resultats) {
            System.out.println(produit);
        }
        System.out.println("================================================\n");
    }

    /**
     * Affiche tous les produits avec un nom ET une catégorie spécifiques
     * 
     * @param nom Nom du produit
     * @param categorie Catégorie du produit
     */
    public void afficherParNomEtCategorie(String nom, String categorie) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : listeProduits) {
            if (produit.getNom().equalsIgnoreCase(nom) &&
                produit.getCategorie().equalsIgnoreCase(categorie)) {
                resultats.add(produit);
            }
        }

        if (resultats.isEmpty()) {
            System.out.println("Aucun produit trouvé avec le nom : " + nom + " et la catégorie : " + categorie);
            return;
        }

        System.out.println("\n========== PRODUITS : " + nom + " (Catégorie: " + categorie + ") ==========");
        for (Produit produit : resultats) {
            System.out.println(produit);
        }
        System.out.println("==================================================\n");
    }

    // ==================== UTILITAIRES ====================

    /**
     * Recherche un produit par son ID
     * 
     * @param idProduit ID du produit à rechercher
     * @return Le produit trouvé ou null s'il n'existe pas
     */
    private Produit rechercherParId(int idProduit) {
        for (Produit produit : listeProduits) {
            if (produit.getIdProduit() == idProduit) {
                return produit;
            }
        }
        return null;
    }

    /**
     * Retourne le nombre total de produits
     * 
     * @return Nombre de produits
     */
    public int getNombreProduits() {
        return listeProduits.size();
    }

    /**
     * Retourne une copie de la liste complète des produits
     * 
     * @return Liste des produits
     */
    public List<Produit> getListeProduits() {
        return new ArrayList<>(listeProduits);
    }

    // ==================== TESTS ====================

    /**
     * Méthode main pour tester la classe GestionProduit
     * 
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        System.out.println("========== TEST DE GESTIONPRODUIT ==========\n");

        // Créer une instance de GestionProduit
        GestionProduit gestion = new GestionProduit();

        // === TEST 1 : Ajouter des produits ===
        System.out.println("--- 1. AJOUT DE PRODUITS ---");
        gestion.ajouter("Tomate", 2.50, 100, "Légumes");
        gestion.ajouter("Pomme", 1.20, 200, "Fruits");
        gestion.ajouter("Carotte", 0.80, 300, "Légumes");
        gestion.ajouter("Orange", 1.50, 150, "Fruits");
        gestion.ajouter("Tomate Bio", 3.50, 50, "Légumes Bio");

        // === TEST 2 : Afficher tous les produits ===
        System.out.println("\n--- 2. AFFICHAGE DE TOUS LES PRODUITS ---");
        gestion.afficher();

        // === TEST 3 : Afficher un produit par ID ===
        System.out.println("--- 3. AFFICHAGE D'UN PRODUIT PAR ID ---");
        gestion.afficherProduit(1);

        // === TEST 4 : Afficher par nom ===
        System.out.println("--- 4. AFFICHAGE PAR NOM (Tomate) ---");
        gestion.afficherParNom("Tomate");

        // === TEST 5 : Afficher par catégorie ===
        System.out.println("--- 5. AFFICHAGE PAR CATÉGORIE (Fruits) ---");
        gestion.afficherParCategorie("Fruits");

        // === TEST 6 : Afficher par nom ET catégorie ===
        System.out.println("--- 6. AFFICHAGE PAR NOM ET CATÉGORIE (Tomate, Légumes) ---");
        gestion.afficherParNomEtCategorie("Tomate", "Légumes");

        // === TEST 7 : Modifier un produit ===
        System.out.println("--- 7. MODIFICATION D'UN PRODUIT ---");
        gestion.modifierPrix(1, 2.99);
        gestion.modifierQuantite(1, 120);
        gestion.afficherProduit(1);

        // === TEST 8 : Modifier nom, prix, quantité individuellement ===
        System.out.println("--- 8. MODIFICATION INDIVIDUELLE ---");
        gestion.modifierNom(2, "Pomme Golden");
        gestion.modifierPrix(3, 1.00);
        gestion.modifierQuantite(4, 200);
        gestion.afficher();

        // === TEST 9 : Obtenir le nombre de produits ===
        System.out.println("--- 9. NOMBRE DE PRODUITS ---");
        System.out.println("Total de produits : " + gestion.getNombreProduits());

        // === TEST 10 : Supprimer un produit ===
        System.out.println("\n--- 10. SUPPRESSION D'UN PRODUIT ---");
        gestion.supprimer(5);
        System.out.println("Total de produits après suppression : " + gestion.getNombreProduits());
        gestion.afficher();

        System.out.println("============================================\n");
    }
}