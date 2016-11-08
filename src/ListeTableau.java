public class ListeTableau implements Liste {

	private int n;
	private Object[] tab;

	public ListeTableau() {

		n = 0;
		tab = new Object[10];
	}

	public int size() {

		return n;
	}

	public void append(Object o) {
		if (size() == tab.length) {
			Object[] newtab = new Object[size() + 1];

			for (int i = 0; i < size(); i++) {
				newtab[i] = tab[i];
			}
			newtab[size()] = o;
			tab = newtab;
		} else {
			tab[size()] = o;
		}
		n++;
	}

	public void prepend(Object o) {
		Object[] newtab;
		if (size() == tab.length) {
			newtab = new Object[size() + 1];
		} else {
			newtab = new Object[tab.length];
		}

		for (int i = 0; i < size(); i++) {

			newtab[i + 1] = tab[i];
		}
		newtab[0] = o;
		tab = newtab;
		n++;
	}

	public Object getFirst() {
		return tab[0];
	}

	public Object getLast() {
		return tab[n - 1];
	}

	public Object removeFirst() {

		Object[] newtab = new Object[tab.length];
		Object toreturn = tab[0];
		for (int i = 0; i < size() - 1; i++) {
			newtab[i] = tab[i + 1];
		}
		n--;
		tab = newtab;
		return toreturn;
	}

	public Object get(int position) {

		if (position < 0 || position > size() - 1)
			throw new ArrayIndexOutOfBoundsException();
		return tab[position];
	}

	public void set(int position, Object o) {
		if (position < 0 || position > size() - 1)
			throw new ArrayIndexOutOfBoundsException();
		tab[position] = o;
	}

	public String toString() {
		String s = "ListeTableau[";
		for (int i = 0; i < size(); i++) {
			if (i == size() - 1) {
				s += tab[i] + "";
			} else {
				s += tab[i] + ",";
			}

		}
		return s + "]";
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * ListeTableau l=new ListeTableau(); l.append("test"); l.prepend("test2");
	 * l.prepend("test3"); l.append("test4"); l.append("test");
	 * l.prepend("test2"); System.out.println(l.size()); l.prepend("test3");
	 * l.append("test4"); l.append("test4"); System.out.println(l.size());
	 * l.append("testttttt"); System.out.println(l.size());
	 * System.out.println(l.tab.length); System.out.println(l.getLast());
	 * System.out.println(l.toString()); }
	 */

}
