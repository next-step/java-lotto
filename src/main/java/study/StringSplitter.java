package study;

public class StringSplitter {

	private final Delimiter delimiter;
	private final String text;
	private final String[] array;

	public StringSplitter(Delimiter delimiter, String text) {
		this.delimiter = delimiter;
		this.text = text;

		array = split();
	}

	private String[] split() {
		return text.split(delimiter.get());
	}

	public String[] get() {
		return array;
	}
}
