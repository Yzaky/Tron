import java.awt.*;

import javax.swing.*;

public class TronPanel extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Arene arn;
	public TronControlPanel tp;

	public TronPanel() {

		tp = new TronControlPanel();
		System.out.println(tp.combo.getSelectedItem());
		setFocusable(true);

		JoueurHumain j1 = new JoueurHumain(new Point(Tron.randomNumberX(),
				Tron.randomNumberY()), Color.RED);
		JoueurHumain j2 = new JoueurHumain(new Point(Tron.randomNumberX(),
				Tron.randomNumberY()), Color.green);
		j1.nouvelle_direction = Tron.randomDirection();
		j2.nouvelle_direction = Tron.randomDirection();

		j1.direction_courante = j1.nouvelle_direction;
		j2.direction_courante = j2.nouvelle_direction;

		Joueur[] tabJ = { j1, j2 };

		arn = new Arene(tabJ);

		tp.startBut.setFocusable(true);
		tp.startBut.addKeyListener(new Movement());
		tp.pausBut.setFocusable(true);
		tp.pausBut.addKeyListener(new Movement());
		arn.addKeyListener(new Movement());
		tp.addKeyListener(new Movement());
		arn.setFocusable(true);
		tp.setFocusable(true);

		this.setLayout(new BorderLayout());

		this.add(tp, BorderLayout.WEST);
		this.add(arn, BorderLayout.CENTER);

	}

}
