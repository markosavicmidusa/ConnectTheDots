package paint;

public class Point {

	private int rowId;
	private int columnId;
	private String value;

	public Point(int rowId, int columnId, String value) {
		this.rowId = rowId;
		this.columnId = columnId;
		this.value = value;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
