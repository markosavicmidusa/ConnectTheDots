package paint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Painter {

	private Paper paper;
	private File model;
	private List<List<Point>> matrixModel;
	private List<String> alphabets;
	private String lineChar;
	private String emptyChar;

	public Painter(File model, String lineChar, String emptyChar) {
		this.model = model;
		this.matrixModel = new ArrayList<List<Point>>();
		this.alphabets = new ArrayList<String>();
		this.lineChar = lineChar;
		this.emptyChar = emptyChar;

		int max_row = 0;
		int max_column = 0;
		int i = 0;

		try {
			Scanner scanner = new Scanner(this.model);

			while (scanner.hasNextLine()) {
				String current_row = scanner.nextLine();
				System.out.println(current_row);
				max_row = i + 1;
				int column_size = current_row.length();
				matrixModel.add(new ArrayList<Point>());
				for (int k = 0; k < column_size; k++) {
					char character = current_row.charAt(k);
					matrixModel.get(i).add(k, new Point(i, k, String.valueOf(character)));
					if (!Character.isWhitespace(character)) {
						alphabets.add(String.valueOf(character));
						if (k + 1 > max_column)
							max_column = k + 1;
					}
				}
				i++;
			}

			System.out.println();

			Collections.sort(alphabets);

			this.paper = new Paper(max_row, max_column, lineChar, emptyChar);

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public File getModel() {
		return model;
	}

	public void setModel(File model) {
		this.model = model;
	}

	public List<List<Point>> getMatrixModel() {
		return matrixModel;
	}

	public void setMatrixModel(List<List<Point>> matrixModel) {
		this.matrixModel = matrixModel;
	}

	public List<String> getAlphabets() {
		return alphabets;
	}

	public void setAlphabets(List<String> alphabets) {
		this.alphabets = alphabets;
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

	public void paintPicture() {

		int row_size = matrixModel.size();
		int alphabets_size = alphabets.size();

		for (int alpha_index = 0; alpha_index < alphabets_size - 1; alpha_index++) {
			String from_letter = alphabets.get(alpha_index);
			String to_letter = alphabets.get(alpha_index + 1);

			Point fromPoint = null;
			Point toPoint = null;

			for (int k = 0; k < row_size; k++) {
				int col_size = matrixModel.get(k).size();
				for (int j = 0; j < col_size; j++) {
					if (from_letter.equals(matrixModel.get(k).get(j).getValue()))
						fromPoint = new Point(k, j, "");
					if (to_letter.equals(matrixModel.get(k).get(j).getValue()))
						toPoint = new Point(k, j, "");
				}
				if (fromPoint != null && toPoint != null) {
					// System.out.println("Crtam " + from_letter + " --> "+ to_letter + " : [" +
					// fromPoint.getRowId() + ", " + fromPoint.getColumnId()
					// + "] --> " + "[" + toPoint.getRowId() + ", " + toPoint.getColumnId() + "]");
					Line line = new Line(fromPoint, toPoint);
					paper = line.drawLine(paper, lineChar);
					break;
				}
			}
		}

	}
}
