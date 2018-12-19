package GUI;

import BL.BL;
import BL.Player;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI extends JFrame {

    private final int width = 6;
    private final int height = 6;
    private final JLabel[][] label = new JLabel[width][height];
    private BL bl = new BL(width, height);

    public GUI() throws HeadlessException {
        this.setLayout(new GridLayout(height + 1, width, 3, 3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        for (int i = 0; i < width; i++) {

            JButton bt = new JButton();
            bt.setText("v");
            bt.setName("" + i);
            bt.addActionListener((ActionEvent e) -> {
                try {
                    bl.makeMove(Integer.parseInt(bt.getName()));
                    if (bl.getWinner() != Player.empty) {
                        JOptionPane.showMessageDialog(null, "Player " + bl.getWinner() + " won!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                this.updateAllLabels();
            });
            this.add(bt);
        }
        for (int i = 0; i < width * height; i++) {
            int x = i % width;
            int y = i / width;
            label[x][y] = new JLabel();
            label[x][y].setOpaque(true);
            label[x][y].setBackground(Color.black);
            this.add(label[x][y]);
        }
    }

    public void updateAllLabels() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (null != bl.getPalyerAt(i, j)) {
                    switch (bl.getPalyerAt(i, j)) {
                        case empty:
                            label[i][j].setBackground(Color.black);
                            break;
                        case one:
                            label[i][j].setBackground(Color.red);
                            break;
                        case two:
                            label[i][j].setBackground(Color.blue);
                            break;
                        default:
                            break;
                    }
                }
            }

        }
    }

    public static void main(String[] args
    ) {
        new GUI().setVisible(true);
    }
}
