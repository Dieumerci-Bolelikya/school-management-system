package model;

public class Eleve {
    private String nom;
    private String prenom;
    private String sexe;
    private String classe;

    // Constructeur par défaut
    public Eleve() {}

    // Constructeur avec paramètres
    public Eleve(String nom, String prenom, String sexe, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.classe = classe;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    // Méthode toString pour afficher facilement un élève
    @Override
    public String toString() {
        return "Eleve{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }
}
