import java.awt.*;


public class JoueurOrdinateur extends Joueur {
	public JoueurOrdinateur(Point p) {
		super.couleur = Color.RED;
		super.trace = new Trace(p);
		super.vivant = true;
	}

}
