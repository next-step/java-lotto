package study;

public enum PatternGroup {
	DELIMITER(2), TEXT(3);

	private final int no;

	PatternGroup(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}
}
