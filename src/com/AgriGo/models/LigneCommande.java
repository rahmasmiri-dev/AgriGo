package com.AgriGo.models;

public class LigneCommande {
    private Produit produit;
    private int quantite;

    public LigneCommande() {
    }

    public LigneCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getTotal() {
        if (produit == null) {
            return 0.0;
        }
        return produit.getPrix() * quantite;
    }

    @Override
    public String toString() {
        return "LigneCommande{produit=" + (produit != null ? produit.getNom() : "null") + ", quantite=" + quantite + ", total=" + getTotal() + "}";
    }
}