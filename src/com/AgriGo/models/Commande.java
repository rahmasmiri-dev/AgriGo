package com.AgriGo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int idCommande;
    private LocalDate date;
    private double total;
    private List<LigneCommande> lignes;

    public Commande() {
        this.date = LocalDate.now();
        this.lignes = new ArrayList<>();
        this.total = 0.0;
    }

    public Commande(int idCommande, LocalDate date) {
        this.idCommande = idCommande;
        this.date = date;
        this.lignes = new ArrayList<>();
        this.total = 0.0;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void ajouterLigne(LigneCommande ligneCommande) {
        if (ligneCommande == null) {
            return;
        }
        lignes.add(ligneCommande);
        calculerTotal();
    }

    public void calculerTotal() {
        double somme = 0.0;
        for (LigneCommande ligne : lignes) {
            somme += ligne.getTotal();
        }
        this.total = somme;
    }
}