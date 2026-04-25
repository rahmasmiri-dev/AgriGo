package com.AgriGo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {

    private int id;
    private LocalDate date;
    private List<LigneCommande> lignes;
    private double total;

    // Constructeur
    public Commande(int id, LocalDate date) {
        this.id = id;
        this.date = date;
        this.lignes = new ArrayList<>();
        this.total = 0;
    }

    // Ajouter ligne
    public void ajouterLigne(LigneCommande ligne) {
        lignes.add(ligne);
    }

    // Calcul total
    public void calculerTotal() {
        total = 0;
        for (LigneCommande l : lignes) {
            total += l.getProduit().getPrix() * l.getQuantite();
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }
}