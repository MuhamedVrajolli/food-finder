package foodfinder;

import foodfinder.gui.MainForm;

public class FoodFinderApplication {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainForm().setVisible(true);
        });
    }
}
