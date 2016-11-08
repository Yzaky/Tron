import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;

public class Tron {

	public Tron() {
		final JFrame f = new JFrame("Le jeu de TRON");
		final TronPanel pan = new TronPanel();
		f.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				pan.arn.requestFocusInWindow();
			}
		});

		f.add(pan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 550);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
		f.setLocation(x, y);
		f.setVisible(true);

		final Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Arene.joueurs[0].trace
						.allonge(Arene.joueurs[0].nouvelle_direction.toString()
								.charAt(0));
				Arene.joueurs[1].trace
						.allonge(Arene.joueurs[1].nouvelle_direction.toString()
								.charAt(0));

				if (Arene.joueurs[0].vivant == true
						&& Arene.joueurs[1].vivant == false) {
					pan.tp.lab3.setBackground(Color.yellow);
					pan.tp.lab3.setText("Joueur gagnant est :1 (rouge)");
				} else if (Arene.joueurs[0].vivant == false
						&& Arene.joueurs[1].vivant == true) {
					pan.tp.lab3.setBackground(Color.yellow);
					pan.tp.lab3.setText("Joueur gagnant est : 2 (vert)");
				}

				pan.repaint();
			}
		});

		pan.tp.nouvBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nouvelle la Partie");
				f.dispose();
				new Tron();

			}
		});

		pan.tp.pausBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pauser la Partie");
				timer.stop();
			}
		});

		pan.tp.startBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Demarer la Partie");
				timer.restart();

			}
		});

	}

	public static int randomNumberX() {
		Random rn = new Random();
		int range = Arene.largeur_grille - 5 - 0 + 5;
		int randomNum = rn.nextInt(range) + 5;
		return randomNum;
	}

	public static int randomNumberY() {
		Random rn = new Random();
		int range = Arene.hauteur_grille - 5 - 0 + 5;
		int randomNum = rn.nextInt(range) + 5;
		return randomNum;
	}

	public static Way randomDirection() {
		Random rn = new Random();
		int range = 4;
		int randomNum = rn.nextInt(range) + 1;
		switch (randomNum) {
		case 1:
			return Way.E;
		case 2:
			return Way.N;
		case 3:
			return Way.O;
		default:
			return Way.S;
		}
	}

	public static void main(String[] args) {
		 new Tron();
	}
}
