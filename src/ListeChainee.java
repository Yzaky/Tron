public class ListeChainee implements Liste {

	private Noeud premier;
	private Noeud dernier;
	private int n;

	/**
	 * Classe Interne Noeud
	 *
	 */
	public class Noeud {

		protected Object Obj;
		protected Noeud suivant;

	}

	/**
	 * Constructeur par defaut
	 */
	public ListeChainee() {

		premier = null;
		dernier = null;
		n = 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#size()
	 * 
	 * @return taille de la liste
	 */
	@Override
	public int size() {
		return n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#append(java.lang.Object) ajout un Objet a la derniere position
	 * de la liste
	 */
	@Override
	public void append(Object o) {

		Noeud noeud = new Noeud();
		noeud.Obj = o;
		noeud.suivant = null;

		if (premier == null) {
			dernier = premier = noeud;
		} else {
			dernier.suivant = noeud;
			dernier = noeud;
		}

		n++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#prepend(java.lang.Object) ajout un objet au debut de la liste
	 */
	@Override
	public void prepend(Object o) {

		Noeud test = new Noeud();
		test.Obj = o;

		if (premier == null) {
			premier = dernier = test;

		} else {
			test.suivant = premier;
			premier = test;
		}
		n++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#getFirst()
	 * 
	 * @return le permier objet de la liste
	 */
	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return premier.Obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#getLast()
	 * 
	 * @return le dernier objet de la liste
	 */
	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return dernier.Obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#removeFirst() supprime le premier objet de la liste
	 */
	@Override
	public Object removeFirst() {

		Noeud test = new Noeud();
		test = premier;
		premier = premier.suivant;
		n--;
		return test.Obj;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#get(int) retrourne l'objet associé a la positoin passée en
	 * parametre
	 */
	@Override
	public Object get(int position) {

		Noeud test = premier;
		if (position < 0 || position > size() - 1)
			throw new ArrayIndexOutOfBoundsException();
		while (test.suivant != null && position > 0) {
			test = test.suivant;
			position--;
		}

		return test.Obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Liste#set(int, java.lang.Object) remplace l'objet associé à la
	 * position passée en parametre avec l'objet o
	 */
	@Override
	public void set(int position, Object o) {
		Noeud test = premier;
		if (position < 0 || position > size() - 1)
			throw new ArrayIndexOutOfBoundsException();
		while (test.suivant != null && position > 0) { // tant que la liste est
														// non vide
			test = test.suivant;
			position--;

		}
		test.Obj = o;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String s = "ListeChainee[";
		Noeud n = premier;

		for (int i = 0; i < size(); i++) {
			if (n == dernier) {
				s += n.Obj + "";
			} else {
				s += n.Obj + ",";
			}

			n = n.suivant;

		}
		return s + "]";
	}
}
