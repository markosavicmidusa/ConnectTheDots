package paint;

import java.util.ArrayList;
import java.util.List;

public class Paper {

	private List<List<Point>> picture;
	private int rowLength;
	private int columnLength;
	private String lineChar;
	private String emptyChar;

	public Paper(int rowLength, int columnLength, String lineChar, String emptyChar) {
		this.picture = new ArrayList<List<Point>>();
		this.rowLength = rowLength;
		this.columnLength = columnLength;
		this.lineChar = lineChar;
		this.emptyChar = emptyChar;

		// Create empty picture
		for (int row_index = 0; row_index < rowLength; row_index++) {
			this.picture.add(new ArrayList<Point>());
			for (int column_index = 0; column_index < columnLength; column_index++)
				this.picture.get(row_index).add(new Point(row_index, column_index, this.emptyChar));
		}
	}

	public List<List<Point>> getPicture() {
		return picture;
	}

	public void setPicture(List<List<Point>> picture) {
		this.picture = picture;
	}

	public int getRowLength() {
		return rowLength;
	}

	public void setRowLength(int rowLength) {
		this.rowLength = rowLength;
	}

	public int getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(int columnLength) {
		this.columnLength = columnLength;
	}

	public String getLineChar() {
		return lineChar;
	}

	public void setLineChar(String lineChar) {
		this.lineChar = lineChar;
	}

	public String getEmptyChar() {
		return emptyChar;
	}

	public void setEmptyChar(String emptyChar) {
		this.emptyChar = emptyChar;
	}

	public void paintDot(Point point) {
		picture.get(point.getRowId()).set(point.getColumnId(), point);
	}

	public void printPicture() {
		int row_count = picture.size();
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < picture.get(i).size(); j++)
				System.out.print(picture.get(i).get(j).getValue());
			System.out.println();
		}
	}
}
