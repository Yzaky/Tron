public class Segment {
	private Point debut, fin;

	public Segment(Point a, Point b) {
		debut = a;
		fin = b;
	}

	public Point getPointDebut() {
		return this.debut;
	}

	public void setPointDebut(Point ledebut) {
		this.debut = ledebut;
	}

	public Point getPointFin() {
		return fin;
	}

	public void setPointFin(Point lafin) {
		this.fin = lafin;
	}

}
