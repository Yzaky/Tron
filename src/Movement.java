import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

	
	static Way lastPas1 = Arene.joueurs[0].direction_courante ; 
	static Way lastPas2 = Arene.joueurs[1].direction_courante;
	
	public Movement() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

		switch (c) {
		case 'w':
			if (lastPas1 != Way.S){
			Arene.joueurs[0].trace.allonge('N');
			Arene.joueurs[0].nouvelle_direction = Way.N;
			lastPas1 =  Way.N;}

			break;
		case 's':
			if (lastPas1 !=  Way.O){
			Arene.joueurs[0].trace.allonge('E');
			Arene.joueurs[0].nouvelle_direction = Way.E;
			lastPas1 =  Way.E;}

			break;
		case 'z':
			if (lastPas1 != Way.N){
			Arene.joueurs[0].trace.allonge('S');
			Arene.joueurs[0].nouvelle_direction = Way.S;
			lastPas1 =  Way.S;}

			break;
		case 'a':
			if (lastPas1 !=  Way.E){
			Arene.joueurs[0].trace.allonge('O');
			Arene.joueurs[0].nouvelle_direction = Way.O;
			lastPas1 =  Way.O;}

			break;
			
			
			// Joueur 2 
		case 'i':
			if (lastPas2 !=  Way.S){
			Arene.joueurs[1].trace.allonge('N');
			Arene.joueurs[1].nouvelle_direction = Way.N;
			lastPas2 =  Way.N;
			}
			break;
		case 'k':
			if (lastPas2 !=  Way.O){
			Arene.joueurs[1].trace.allonge('E');
			Arene.joueurs[1].nouvelle_direction = Way.E;
			lastPas2 =  Way.E;}
			break;
		case 'm':
			if (lastPas2 !=  Way.N){
			Arene.joueurs[1].trace.allonge('S');
			Arene.joueurs[1].nouvelle_direction = Way.S;
			lastPas2 =  Way.S;}
			break;
		case 'j':
			if (lastPas2 !=  Way.E){
			Arene.joueurs[1].trace.allonge('O');
			Arene.joueurs[1].nouvelle_direction = Way.O;
			lastPas2 =  Way.O;}
			break;

		default:
			break;
		}

		

		Point tete = Arene.joueurs[1].trace.PointTete();
		System.out.println(tete.getPointX() + "ds" + tete.getPointY());

		System.out.println("Caractère appuyé: " + c);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
