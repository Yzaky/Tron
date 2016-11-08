public class Point {
	// coordonnee horizontale entiere
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getPointX() {
		return this.x;
	}

	public void setPointX(int x) {
		this.x = x;
	}

	public int getPointY() {
		return this.y;
	}

	public void setPointY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	

}
