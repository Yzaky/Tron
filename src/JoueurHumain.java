import java.awt.*;


public class JoueurHumain extends Joueur {

	public JoueurHumain(Point p, Color c) {
		super.couleur = c;
		super.trace = new Trace(p);
		super.vivant = true;
	
	}

}
