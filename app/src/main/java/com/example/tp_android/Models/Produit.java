package com.example.tp_android.Models;

public class Produit {

    String id;
    String nom;
    double prix;
    int quantite;
    String description;

    public Produit() {
    }

    public Produit(String id, String nom, double prix, int quantite, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "Id='" + id + '\'' +
                ", Nom='" + nom + '\'' +
                ", Prix=" + prix +
                ", Quantite=" + quantite +
                ", Description='" + description + '\'' +
                '}';
    }
}
