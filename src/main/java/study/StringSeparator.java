package study;

public class StringSeparator {

	private final Delimiter delimiter;
	private final String text;

	public StringSeparator(Delimiter delimiter, String text) {
		this.delimiter = delimiter;
		this.text = text;
	}

	public String[] split() {
		return text.split(delimiter.get());
	}
}
