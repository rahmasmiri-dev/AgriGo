public class GestionProduit {

    private Catalogue catalogue;

    public GestionProduit(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    // Ajouter produit
    public void ajouterProduit(Produit produit) {
        catalogue.ajouterProduit(produit);
        System.out.println("✓ Produit ajouté : " + produit.getNom());
    }

    // Supprimer produit
    public void supprimerProduit(Produit produit) {
        catalogue.supprimerProduit(produit);
        System.out.println("✓ Produit supprimé : " + produit.getNom());
    }

    // Modifier nom
    public void modifierNomProduit(Produit produit, String nouveauNom) {
        produit.setNom(nouveauNom);
        System.out.println("✓ Nom modifié : " + nouveauNom);
    }

    // Modifier prix
    public void modifierPrixProduit(Produit produit, double prix) {
        produit.setPrix(prix);
        System.out.println("✓ Prix modifié : " + prix);
    }

    // Modifier quantité
    public void modifierQuantiteProduit(Produit produit, int quantite) {
        produit.setQuantite(quantite);
        System.out.println("✓ Quantité modifiée : " + quantite);
    }

    // Modifier tout
    public void modifierProduit(Produit produit, String nom, double prix, int quantite) {
        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setQuantite(quantite);
        System.out.println("✓ Produit modifié بالكامل");
    }
}