school-management-system/
│
├── model/                # Classes métier
│   ├── Eleve.java
│   ├── Paiement.java
│   ├── Note.java
│   ├── Bulletin.java
│
├── database/             # Connexion et requêtes SQL
│   ├── DatabaseConnection.java
│   ├── EleveDAO.java
│   ├── PaiementDAO.java
│   ├── NoteDAO.java
│   ├── BulletinDAO.java
│
├── ui/                   # Interfaces Swing
│   ├── MainMenu.java
│   ├── InscriptionEleve.java
│   ├── PaiementFrais.java
│   ├── EncodageNotes.java
│   ├── GenerationBulletin.java
│
├── controller/           # Logique de liaison
│   ├── EleveController.java
│   ├── PaiementController.java
│   ├── NoteController.java
│   ├── BulletinController.java
│
├── tests/                # Vérifications
│   ├── TestInscription.java
│   ├── TestPaiement.java
│   ├── TestNotes.java
│   ├── TestBulletin.java
│
└── resources/
    ├── database.sql      # Script MySQL
    └── diagrammeBD.png   # Schéma relationnel
