package controller;

import monpackage.EleveDAO;
import database.EleveDAO;
import model.Eleve;
import java.util.List;

public class EleveController {

    private EleveDAO dao;

    public EleveController() {
        dao = new EleveDAO();
    }

    public void inscrire(Eleve e) {
        dao.ajouter(e);
    }

    public List<Eleve> lister() {
        return dao.getAll();
    }
}