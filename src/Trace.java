
public class Trace {
	Liste segments = new ListeChainee();
	Point initial;

	public Trace(Point p) {
		this.initial = p;
		segments.append(new Segment(initial, initial));
	}

	public void allonge(char direction) {

		if (segments.size() == 0) {
			switch (direction) {
			case 'N':
				segments.append(new Segment(initial, new Point(initial
						.getPointX(), initial.getPointY() - 1)));
				break;
			case 'S':
				segments.append(new Segment(initial, new Point(initial
						.getPointX(), initial.getPointY() + 1)));
				break;
			case 'E':
				segments.append(new Segment(initial, new Point(initial
						.getPointX() + 1, initial.getPointY())));
				break;
			case 'O':
				segments.append(new Segment(initial, new Point(initial
						.getPointX() - 1, initial.getPointY())));
				break;
			}
		} else {

			Segment lastSegment = (Segment) segments.getLast();
			Point finLastSeg = lastSegment.getPointFin(); 

			switch (direction) {
			case 'N':
				segments.append(new Segment(finLastSeg, new Point(
						finLastSeg.getPointX(),
						finLastSeg.getPointY() - 1)));
				break;
			case 'S':
				segments.append(new Segment(finLastSeg, new Point(
						finLastSeg.getPointX(),
						finLastSeg.getPointY() + 1)));
				break;
			case 'E':
				segments.append(new Segment(finLastSeg, new Point(
						finLastSeg.getPointX() + 1, finLastSeg
								.getPointY())));
				break;
			case 'O':
				segments.append(new Segment(finLastSeg, new Point(
						finLastSeg.getPointX() - 1, finLastSeg
								.getPointY())));
				break;
			}
		}
	}

	public Point PointTete() {
		Segment lastSegment = (Segment) segments.getLast();
		return lastSegment.getPointFin();
	}

	public boolean contient(Point p)

	{
		Segment f = (Segment) segments.getFirst();
		Point fin = f.getPointFin();
		for (int i = 0; i < segments.size(); i++) {
			if (fin.getPointX() == p.getPointX()
					&& fin.getPointY() == p.getPointY()) {
				return true;
			}

		}
		return false;
	}



}
