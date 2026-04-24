package com.AgriGo.models;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private static int compteurId = 1;
    private static List<Utilisateur> utilisateurs = new ArrayList<>();

    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    // Constructeur
    public Utilisateur(String nom, String email, String motDePasse) {
        this.id = compteurId++;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Utilisateur(int id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    // ================= INSCRIPTION =================
    public static boolean sInscrire(String nom, String email, String motDePasse) {
        for (Utilisateur u : utilisateurs) {
            if (u.email.equals(email)) {
                System.out.println("❌ Email déjà utilisé");
                return false;
            }
        }

        Utilisateur nouveau = new Utilisateur(nom, email, motDePasse);
        utilisateurs.add(nouveau);
        System.out.println("✅ Inscription réussie : " + nom);
        return true;
    }

    // ================= AUTHENTIFICATION =================
    public static Utilisateur sAuthentifier(String email, String mdp) {
        for (Utilisateur u : utilisateurs) {
            if (u.getEmail().equals(email) && u.getMotDePasse().equals(mdp)) {
                return u;
            }
        }
        return null;
    }

    // ================= GET LIST =================
    public static List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    @Override
    public String toString() {
        return nom + " (" + email + ")";
    }
}