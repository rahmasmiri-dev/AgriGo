package com.AgriGo.models;

public class Client extends Utilisateur {
    public Client(int id, String nom, String email, String motDePasse) {
        super(id, nom, email, motDePasse);
    }
    public void consulterCatalogue(Catalogue catalogue) {
        System.out.println("Le client consulte le catalogue.");
    }
    public void rechercherProduit(Catalogue catalogue, String nomProduit) {
        System.out.println("Recherche du produit : " + nomProduit);
    }
}
