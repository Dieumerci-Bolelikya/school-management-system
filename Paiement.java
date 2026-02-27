package model;

import java.time.LocalDate;

public class Paiement {
    private int id;
    private int eleveId;
    private double montant;
    private String statut;
    private LocalDate datePaiement;

    public Paiement(int id, int eleveId, double montant, String statut, LocalDate datePaiement) {
        this.id = id;
        this.eleveId = eleveId;
        this.montant = montant;
        this.statut = statut;
        this.datePaiement = datePaiement;
    }

    // Getters
    public int getId() { return id; }
    public int getEleveId() { return eleveId; }
    public double getMontant() { return montant; }
    public String getStatut() { return statut; }
    public LocalDate getDatePaiement() { return datePaiement; }

    @Override
    public String toString() {
        return "Paiement de " + montant + " (" + statut + ")";
    }
}
