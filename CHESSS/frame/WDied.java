package frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Pieces.Piece;


public class WDied extends JFrame {


    public WDied() {
        super("WDied");
        loadInterface();
    }

    private void loadInterface() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(600, 250));

        initializePiece("");



        this.pack();
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }

    private void initializePiece(String d) {
        JLabel piece = new JLabel();
        d="";

        String s = "/Resources/images/"+d+".png";
        piece.setIcon(new ImageIcon(getClass().getResource(s)));
        this.add(piece);
    }

}