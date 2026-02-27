package tests;

import controller.EleveController;
import model.Eleve;

public class TestEleveDAO {
    public static void main(String[] args) {

        EleveController c = new EleveController();

        Eleve e = new Eleve(0, "Test", "Eleve", "Masculin", "6e A");
        c.inscrire(e);

        c.lister().forEach(el ->
            System.out.println(el.getNom())
        );
    }
}