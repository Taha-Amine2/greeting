package fr.ubo.hello.bean;

/**
 * Classe représentant une salutation avec un message et un auteur.
 */
public class Greeting {
    private String message;
    private String auteur;

    public Greeting() {}

    public Greeting(String message, String auteur) {
        this.message = message;
        this.auteur = auteur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
