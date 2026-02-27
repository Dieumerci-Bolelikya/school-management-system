package database;

import model.Eleve;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveDAO {
    public void ajouter(Eleve e) {
        String sql = "INSERT INTO eleve(nom, prenom, sexe, classe) VALUES(?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getSexe());
            ps.setString(4, e.getClasse());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Eleve> getAll() {
        List<Eleve> liste = new ArrayList<>();
        String sql = "SELECT id, nom, prenom, sexe, classe FROM eleve";
        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Eleve e = new Eleve(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("sexe"),
                    rs.getString("classe")
                );
                liste.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }
}
