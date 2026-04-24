import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

public class Catalogue {
    private final List<Produit> produits = new ArrayList<>();
=======
import java.util.stream.Collectors;

public class Catalogue {
    private List<Produit> produits;

    public Catalogue() {
        this.produits = new ArrayList<>();
    }
>>>>>>> Rahma_br

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

<<<<<<< HEAD
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
=======
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

    // Pour compatibilité avec Admin
    public int nombreDeProduits() {
        return getNombreProduits();
    }

    // Pour compatibilité avec Client
    public void rechercherProduit(String nomProduit) {
        List<Produit> resultats = rechercherParNom(nomProduit);
        if (resultats.isEmpty()) {
            System.out.println("Aucun produit trouvé pour : " + nomProduit);
        } else {
            System.out.println("Produits trouvés pour '" + nomProduit + "' :");
            for (Produit p : resultats) {
                System.out.println(p);
            }
        }
    }
}
>>>>>>> Rahma_br
