import java.awt.*;

import javax.swing.*;

public class Arene extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int largeur_grille = 500, hauteur_grille = 500;
	public static Joueur[] joueurs;

	public Arene(Joueur[] lesj) {

		joueurs = lesj;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, largeur_grille, hauteur_grille);
		g.drawLine(0, 0, largeur_grille, 0);
		g.drawLine(largeur_grille, 0, largeur_grille, hauteur_grille);
		g.drawLine(largeur_grille, hauteur_grille, 0, hauteur_grille);
		g.drawLine(0, hauteur_grille, 0, 0);

		for (int i = 0; i < joueurs.length; i++) {
			Joueur j = joueurs[i];

			if (j.vivant) {

				g.setColor(j.couleur);

				for (int k = 0; k < j.trace.segments.size(); k++) {

					int xdeb = ((Segment) (j.trace.segments.get(k)))
							.getPointDebut().getPointX();
					int ydeb = ((Segment) (j.trace.segments.get(k)))
							.getPointDebut().getPointY();
					int xfin = ((Segment) (j.trace.segments.get(k)))
							.getPointFin().getPointX();
					int yfin = ((Segment) (j.trace.segments.get(k)))
							.getPointFin().getPointY();

					int xdernier = ((Segment) (j.trace.segments
							.get(j.trace.segments.size() - 1))).getPointFin()
							.getPointX();
					int ydernier = ((Segment) (j.trace.segments
							.get(j.trace.segments.size() - 1))).getPointFin()
							.getPointY();

					if ((xfin - 1) == xdernier && (yfin - 1) == ydernier) {
						System.out.println("mort du Joueeeur == "
								+ j.couleur.toString() + "gagn=");
						j.vivant = false;
					}

					for (int z = 0; z < joueurs.length; z++) {
						if (z != i && joueurs[z].vivant == true) {
							Joueur jo = joueurs[z];

							for (int l = 0; l < jo.trace.segments.size(); l++) {

								int xfint = ((Segment) (jo.trace.segments
										.get(l))).getPointFin().getPointX();
								int yfint = ((Segment) (jo.trace.segments
										.get(l))).getPointFin().getPointY();

								if (xfin == xfint && yfin == yfint) {
									System.out.println("mort du Joueeeur == "
											+ jo.couleur.toString() + "gagn="
											+ l);
									jo.vivant = false;
								}
							}
						}
					}

					if (xfin <= 0 || yfin <= 0 || xfin >= largeur_grille
							|| yfin >= hauteur_grille) {
						j.vivant = false;
						System.out.println("joueur mort face au mur :" + i);
					}

					if (j.vivant == true)
						g.drawLine(xdeb, ydeb, xfin, yfin);
				}

			}

		}

	}
}
