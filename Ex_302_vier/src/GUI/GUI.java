package GUI;

import BL.BL;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame {

    private final int width = 5;
    private JLabel[][] label;
    private BL bl = new BL(6, 5);

    public GUI() throws HeadlessException {
        this.setLayout(new GridLayout(6, width + 1, 3, 3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 700);
        for (int i = 0; i < 6; i++) {

            JButton bt = new JButton();
            bt.setText("v");
            bt.setName("bt" + i);
            bt.addActionListener((ActionEvent e) -> {
                System.out.println(bt.getName());
                bl.makeMove(Integer.parseInt(bt.getName()));
            });
            this.add(bt);
        }
        for (int i = 0; i < 30; i++) {
            //label[][]=new JLabel("lb"+x+"."+y);
            int x = i % width;
            int y = i / width;
            label[x][y].setOpaque(true);
            label[x][y].setBackground(Color.black);
            this.add(label[x][y]);
        }
    }

    public static void main(String[] args
    ) {
        new GUI().setVisible(true);
    }
}
