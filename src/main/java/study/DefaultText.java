package study;

public enum DefaultText {
	NUMBER("0"), EMPTY("");

	private final String text;

	DefaultText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
