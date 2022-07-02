package frame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import game.*;
import Pieces.Piece;

public class Panel extends JPanel {

	Game game;
	int ti, tj;
	public static int xx, yy;
	JPanel panel = this;

	public Panel(String fenString, boolean AIMode) throws IOException {
		this.setFocusable(true);
		this.addMouseListener(new Listener());
		this.addMouseMotionListener(new Listener());

		game = new Game(fenString, AIMode);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g, xx, yy, this);
	}

	class Listener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				int x = e.getX() / Piece.size;
				int y = e.getY() / Piece.size;
				Game.drag = false;
				game.active = null;
				game.selectPiece(x, y);
				revalidate();
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			ti = e.getX() / Piece.size;
			tj = e.getY() / Piece.size;
			if (Game.board.getPiece(ti, tj) != null) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			revalidate();
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (!Game.drag && game.active != null) {
				game.active = null;
			}
			if (SwingUtilities.isLeftMouseButton(e)) {
				game.selectPiece(e.getX() / Piece.size, e.getY() / Piece.size);
				Game.drag = true;
				xx = e.getX();
				yy = e.getY();
			}
			revalidate();
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int x = e.getX() / Piece.size;
			int y = e.getY() / Piece.size;
			try {
				game.move(x, y);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			revalidate();
			repaint();
		}

	}

}
