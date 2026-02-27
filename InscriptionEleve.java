package ui;

import controller.EleveController;
import model.Eleve;

public class InscriptionEleve extends JFrame {

    private EleveController controller = new EleveController();

    private void btnAjouterAction() {
        Eleve e = new Eleve(
            0,
            txtNom.getText(),
            txtPrenom.getText(),
            txtClasse.getText(),
            cbSexe.getSelectedItem().toString()
        );
        controller.inscrireEleve(e);
    }
}