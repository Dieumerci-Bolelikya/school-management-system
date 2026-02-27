public class Eleve {
    private int id;
    private String nom;
    private String classe;
    private String sexe;

    public Eleve(int id, String nom, String classe, String sexe) {
        this.id = id;
        this.nom = nom;
        this.classe = classe;
        this.sexe = sexe;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getClasse() { return classe; }
    public String getSexe() { return sexe; }
}