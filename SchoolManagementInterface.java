import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SchoolManagementInterface extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainContentPanel;

    public SchoolManagementInterface() {
        // Configuration de la fenêtre principale
        setTitle("Système de Gestion Scolaire - EduGest");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setLayout(new BorderLayout());

        // 1. Barre de Menu Supérieure
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemQuitter = new JMenuItem("Quitter");
        itemQuitter.addActionListener(e -> System.exit(0));
        menuFichier.add(itemQuitter);
        menuBar.add(menuFichier);
        setJMenuBar(menuBar);

        // 2. Menu Latéral (Sidebar)
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(8, 1, 5, 10));
        sidebarPanel.setBackground(new Color(44, 62, 80)); // Bleu nuit moderne
        sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));

        JLabel logoLabel = new JLabel("  EduGest", SwingConstants.CENTER);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 22));
        sidebarPanel.add(logoLabel);

        // Noms des menus
        String[] menuItems = {"Tableau de bord", "Élèves", "Professeurs", "Cours", "Finances", "Paramètres"};
        
        // 3. Panneau Principal (Contenu)
        cardLayout = new CardLayout();
        mainContentPanel = new JPanel(cardLayout);

        // Création et ajout des boutons et des panneaux associés
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setForeground(Color.WHITE);
            menuButton.setBackground(new Color(52, 73, 94));
            menuButton.setFocusPainted(false);
            menuButton.setFont(new Font("Arial", Font.PLAIN, 16));
            
            // Action du bouton : changer la vue
            menuButton.addActionListener(e -> cardLayout.show(mainContentPanel, item));
            sidebarPanel.add(menuButton);

            // Ajouter les vues spécifiques
            if (item.equals("Tableau de bord")) {
                mainContentPanel.add(createDashboardPanel(), item);
            } else if (item.equals("Élèves")) {
                mainContentPanel.add(createStudentsPanel(), item);
            } else {
                // Pages génériques pour les autres menus
                mainContentPanel.add(createGenericPanel(item), item);
            }
        }

        // 4. Assemblage
        add(sidebarPanel, BorderLayout.WEST);
        add(mainContentPanel, BorderLayout.CENTER);
    }

    // --- CRÉATION DES DIFFÉRENTES PAGES ---

    // Page : Tableau de bord
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Vue d'ensemble");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Cartes de statistiques
        statsPanel.add(createStatCard("Total Élèves", "1 254", new Color(41, 128, 185)));
        statsPanel.add(createStatCard("Professeurs", "85", new Color(39, 174, 96)));
        statsPanel.add(createStatCard("Salles de Classe", "42", new Color(142, 68, 173)));
        statsPanel.add(createStatCard("Revenus du Mois", "12 500 $", new Color(243, 156, 18)));

        panel.add(statsPanel, BorderLayout.CENTER);
        return panel;
    }

    // Design d'une carte de statistique (pour le tableau de bord)
    private JPanel createStatCard(String title, String value, Color bgColor) {
        JPanel card = new JPanel(new GridLayout(2, 1));
        card.setBackground(bgColor);
        card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 36));

        card.add(titleLabel);
        card.add(valueLabel);
        return card;
    }

    // Page : Gestion des élèves (Formulaire + Tableau)
    private JPanel createStudentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Titre
        JLabel title = new JLabel("Gestion des Élèves", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        // Formulaire en haut
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        JTextField txtNom = new JTextField(12);
        JTextField txtClasse = new JTextField(10);
        JComboBox<String> cbSexe = new JComboBox<>(new String[]{"Masculin", "Féminin"});
        JButton btnAjouter = new JButton("Ajouter l'élève");
        btnAjouter.setBackground(new Color(39, 174, 96));
        btnAjouter.setForeground(Color.WHITE);

        formPanel.add(new JLabel("Nom Complet:"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Classe:"));
        formPanel.add(txtClasse);
        formPanel.add(new JLabel("Sexe:"));
        formPanel.add(cbSexe);
        formPanel.add(btnAjouter);

        // Tableau au centre
        String[] colonnes = {"ID", "Nom Complet", "Classe", "Sexe", "Date d'inscription"};
        DefaultTableModel tableModel = new DefaultTableModel(colonnes, 0);
        JTable table = new JTable(tableModel);
        
        // Données fictives
        tableModel.addRow(new Object[]{"1", "Jean Kabongo", "6ème A", "Masculin", "2023-09-02"});
        tableModel.addRow(new Object[]{"2", "Marie Dupont", "5ème B", "Féminin", "2023-09-03"});

        // Action d'ajout (Simulation)
        btnAjouter.addActionListener(e -> {
            String nom = txtNom.getText();
            String classe = txtClasse.getText();
            String sexe = cbSexe.getSelectedItem().toString();
            if(!nom.isEmpty() && !classe.isEmpty()) {
                tableModel.addRow(new Object[]{tableModel.getRowCount()+1, nom, classe, sexe, "Aujourd'hui"});
                txtNom.setText("");
                txtClasse.setText("");
            } else {
                JOptionPane.showMessageDialog(panel, "Veuillez remplir tous les champs !");
            }
        });

        // Conteneur central
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(centerPanel, BorderLayout.CENTER);
        return panel;
    }

    // Page : Générique pour les autres sections (en attente de développement)
    private JPanel createGenericPanel(String nomPage) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Page : " + nomPage + " (En construction...)", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.ITALIC, 24));
        label.setForeground(Color.GRAY);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // --- MÉTHODE PRINCIPALE ---
    public static void main(String[] args) {
        // Appliquer le style visuel de l'OS de l'utilisateur
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lancement de l'interface
        SwingUtilities.invokeLater(() -> {
            SchoolManagementInterface app = new SchoolManagementInterface();
            app.setVisible(true);
        });
    }
}