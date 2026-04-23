import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogue {
    private List<Produit> produits;

    public Catalogue() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

    public Produit rechercherParId(int id) {
        for (Produit produit : produits) {
            if (produit.getIdProduit() == id) {
                return produit;
            }
        }
        return null;
    }

    public List<Produit> rechercherParNom(String nom) {
        return produits.stream()
                .filter(p -> p.getNom().toLowerCase().contains(nom.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Produit> getProduits() {
        return new ArrayList<>(produits);
    }

    public void afficherCatalogue() {
        System.out.println("\n=== Catalogue ===");
        if (produits.isEmpty()) {
            System.out.println("Le catalogue est vide.");
        } else {
            for (Produit produit : produits) {
                System.out.println(produit);
            }
        }
        System.out.println("=================\n");
    }

    public int getNombreProduits() {
        return produits.size();
    }
}