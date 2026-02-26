-- Fichier SQL pour le projet de gestion scolaire

-- 1️⃣ Supprimer la base si elle existe
DROP DATABASE IF EXISTS gestion_scolaire;

-- 2️⃣ Créer la base
CREATE DATABASE gestion_scolaire;
USE gestion_scolaire;

-- 3️⃣ Créer la table eleve
CREATE TABLE eleve (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    dateNaissance DATE,
    classe VARCHAR(20)
);

-- 4️⃣ Créer la table frais
CREATE TABLE frais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eleve_id INT NOT NULL,
    montant DOUBLE NOT NULL,
    statut VARCHAR(20) DEFAULT 'non payé',
    FOREIGN KEY (eleve_id) REFERENCES eleve(id) ON DELETE CASCADE
);

-- 5️⃣ Créer la table note
CREATE TABLE note (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eleve_id INT NOT NULL,
    matiere VARCHAR(50),
    note DOUBLE,
    FOREIGN KEY (eleve_id) REFERENCES eleve(id) ON DELETE CASCADE
);

-- 6️⃣ Créer la table bulletin
CREATE TABLE bulletin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    eleve_id INT NOT NULL,
    moyenne DOUBLE,
    appreciation VARCHAR(100),
    FOREIGN KEY (eleve_id) REFERENCES eleve(id) ON DELETE CASCADE
);

-- 7️⃣ Ajouter un élève de test
INSERT INTO eleve (nom, prenom, dateNaissance, classe)
VALUES ('Kayembe', 'Josmi', '2005-03-12', '5eme A');

-- 8️⃣ Vérifier les élèves
SELECT * FROM eleve;
