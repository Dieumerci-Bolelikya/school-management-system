-- Créer la base de données
CREATE DATABASE IF NOT EXISTS gestion_scolaire;
USE gestion_scolaire;

-- Table Eleve
CREATE TABLE IF NOT EXISTS eleve (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    sexe VARCHAR(20) NOT NULL,
    classe VARCHAR(50) NOT NULL
);

-- Table Note
CREATE TABLE IF NOT EXISTS note (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eleveId INT NOT NULL,
    matiere VARCHAR(100) NOT NULL,
    valeur DOUBLE NOT NULL,
    FOREIGN KEY (eleveId) REFERENCES eleve(id) ON DELETE CASCADE
);

-- Table Paiement
CREATE TABLE IF NOT EXISTS paiement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eleveId INT NOT NULL,
    montant DOUBLE NOT NULL,
    statut VARCHAR(50) NOT NULL,
    datePaiement DATE NOT NULL,
    FOREIGN KEY (eleveId) REFERENCES eleve(id) ON DELETE CASCADE
);
