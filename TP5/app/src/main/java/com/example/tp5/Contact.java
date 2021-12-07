package com.example.tp5;

public class Contact {
    String nom;
    String prénom;
    String imageURL;

    public Contact(String prenom, String nom, String imageUrl) {
        this.prénom = prenom;
        this.nom = nom;
        this.imageURL = imageUrl;
    }


    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getImageURL() {

        return imageURL;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setImageURL(String imageURL) {

        this.imageURL = imageURL;

    }
}