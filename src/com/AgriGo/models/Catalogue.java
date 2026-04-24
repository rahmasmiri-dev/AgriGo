import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private final List<Produit> produits = new ArrayList<>();

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

    public void afficherCatalogue() {
        if (produits.isEmpty()) {
            System.out.println("Catalogue vide.");
            return;
        }
        System.out.println("Catalogue des produits :");
        for (Produit produit : produits) {
            System.out.println(" - " + produit);
        }
    }

    public void rechercherProduit(String nomProduit) {
        boolean trouve = false;
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nomProduit)) {
                System.out.println("Produit trouvé : " + produit);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun produit trouvé pour : " + nomProduit);
        }
    }

    public List<Produit> rechercherParPrixMin(double prixMin) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getPrix() >= prixMin) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public List<Produit> rechercherParPrixMax(double prixMax) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getPrix() <= prixMax) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public List<Produit> rechercherParPlage(double prixMin, double prixMax) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getPrix() >= prixMin && produit.getPrix() <= prixMax) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public List<Produit> rechercherParQuantiteMin(int quantiteMin) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getQuantite() >= quantiteMin) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public List<Produit> obtenirTousProduits() {
        return new ArrayList<>(produits);
    }

    public int nombreDeProduits() {
        return produits.size();
    }
}
