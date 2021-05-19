package study;

public class StringSeparator {

	private final String text;

	private String delimiter;

	public StringSeparator(String delimiter, String text) {
		this.delimiter = delimiter;

		if (delimiter == null || delimiter.isEmpty()) {
			this.delimiter = Delimiter.DEFAULT_DELIMITER;
		}

		this.text = text;
	}

	public String[] split() {
		return text.split(delimiter);
	}
}
