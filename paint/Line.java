package paint;

public class Line {

	private Point fromPoint;
	private Point toPoint;

	public Line(Point fromPoint, Point toPoint) {
		this.fromPoint = fromPoint;
		this.toPoint = toPoint;
	}

	public Point getFromPoint() {
		return fromPoint;
	}

	public void setFromPoint(Point fromPoint) {
		this.fromPoint = fromPoint;
	}

	public Point getToPoint() {
		return toPoint;
	}

	public void setToPoint(Point toPoint) {
		this.toPoint = toPoint;
	}

	public Paper drawLine(Paper paper, String lineChar) {

		if (fromPoint.getRowId() == toPoint.getRowId())
			paper = drawHorizontalLine(paper, lineChar);
		else if (fromPoint.getColumnId() == toPoint.getColumnId())
			paper = drawVerticalLine(paper, lineChar);
		else
			paper = drawDiagonalLine(paper, lineChar);

		return paper;
	}

	private Paper drawHorizontalLine(Paper paper, String lineChar) {

		// System.out.println("horizontal line : [" + fromPoint.getRowId() + ", " +
		// fromPoint.getColumnId() + "] --> [" + toPoint.getRowId()
		// + ", " + toPoint.getColumnId() + "]");
		int column_direction = fromPoint.getColumnId() < toPoint.getColumnId() ? 1 : -1;
		for (int i = fromPoint.getColumnId(); i * column_direction <= toPoint.getColumnId() * column_direction; i = i
				+ column_direction)
			paper.paintDot(new Point(fromPoint.getRowId(), i, lineChar));

		return paper;
	}

	private Paper drawVerticalLine(Paper paper, String lineChar) {

		// System.out.println("vertical line : [" + fromPoint.getRowId() + ", " +
		// fromPoint.getColumnId() + "] --> [" + toPoint.getRowId()
		// + ", " + toPoint.getColumnId() + "]");
		int row_direction = fromPoint.getRowId() < toPoint.getRowId() ? 1 : -1;
		for (int i = fromPoint.getRowId(); i * row_direction <= toPoint.getRowId() * row_direction; i = i
				+ row_direction)
			paper.paintDot(new Point(i, fromPoint.getColumnId(), lineChar));

		return paper;
	}

	private Paper drawDiagonalLine(Paper paper, String lineChar) {

		int vertical_distance = Math.abs(fromPoint.getRowId() - toPoint.getRowId());
		int horizontal_distance = Math.abs(fromPoint.getColumnId() - toPoint.getColumnId());
		boolean square_diagonal = vertical_distance == horizontal_distance ? true : false;

		if (square_diagonal) {
			// System.out.println("square diagonal line : [" + fromPoint.getRowId() + ", " +
			// fromPoint.getColumnId() + "] --> [" + toPoint.getRowId()
			// + ", " + toPoint.getColumnId() + "]");
			int row_direction = fromPoint.getRowId() < toPoint.getRowId() ? 1 : -1;

			int column_direction = fromPoint.getColumnId() < toPoint.getColumnId() ? 1 : -1;

			for (int i = fromPoint.getRowId(), j = fromPoint.getColumnId(); i * row_direction <= toPoint.getRowId()
					* row_direction
					&& j * column_direction <= toPoint.getColumnId() * column_direction; i = i + row_direction, j = j
							+ column_direction) {
				// System.out.println("[" + i + ", " + j + "]");
				paper.paintDot(new Point(i, j, lineChar));
			}
		} else {
			// System.out.println("diagonal line, not square : [" + fromPoint.getRowId() +
			// ", " + fromPoint.getColumnId() + "] --> [" + toPoint.getRowId()
			// + ", " + toPoint.getColumnId() + "]");
			//Ovde mozda ne treba da se izvrse ove dve linije koda, jer ako diagonala nije kvadratna,
			//onda nema linije, odnosno te dve tacke mogu i da ostanu nepromenjene(prethodno crtanje linija je mozda obuhvatilo
			//ove tacke pa u trenutku izvrsavanja koda tacke mogu da imaju i " " i "*" vrednost)
			paper.paintDot(new Point(fromPoint.getRowId(), fromPoint.getColumnId(), lineChar));
			paper.paintDot(new Point(toPoint.getRowId(), toPoint.getColumnId(), lineChar));
		}

		return paper;
	}
}
