package com.AgriGo.models;
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

    // compatibilité
    public int nombreDeProduits() {
        return getNombreProduits();
    }
    public List<Produit> obtenirTousProduits() {
    return new ArrayList<>(produits);
}
}