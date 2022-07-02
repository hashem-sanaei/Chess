package frame;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame {

	public static final int WIDTH = 640;
	public static final int HEIGTH = 640;

	public Frame(String fenString, boolean AIMode) throws IOException {
		setLayout(new BorderLayout());
		add(new Panel(fenString, AIMode));
		this.setTitle("Chess");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.getContentPane().setPreferredSize(new Dimension(WIDTH, WIDTH));
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
