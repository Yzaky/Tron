
import javax.swing.*;

public class TronControlPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton startBut;
	public JButton pausBut;
	public JButton nouvBut;
	public JLabel lab;
	public JLabel lab2;
	public JLabel lab3;
	public JPanel top;
	public JComboBox<String> combo;
	public JTextField txtF;

	public TronControlPanel() {
		startBut = new JButton("Demarrer");
		pausBut = new JButton("Pause");
		nouvBut = new JButton("Nouvelle partie");

		lab = new JLabel(" Directions : W,S,Z,A  ||  I,K,M,J ");
		lab2 = new JLabel("millisecondes :");
		lab3 = new JLabel("Joueur gagnant est :");
		txtF = new JTextField("");
		txtF.setSize(10, 10);

		String[] tab = { "2 joueurs", "1 joueur contre PC" };
		combo = new JComboBox<String>(tab);
		combo.setSize(10, 10);

		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));
		top.add(lab3);
		top.add(lab);
		top.add(startBut);
		top.add(pausBut);
		top.add(nouvBut);
		top.add(combo);
		top.add(lab2);
		top.add(txtF);

		this.add(top);

	}
}