package model;

public class Note {
    private int id;
    private int eleveId;
    private String matiere;
    private double valeur;

    public Note(int id, int eleveId, String matiere, double valeur) {
        this.id = id;
        this.eleveId = eleveId;
        this.matiere = matiere;
        this.valeur = valeur;
    }
}