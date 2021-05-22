package calculator;

public class Input {

	private String text;

	public Input(String text) {
		this.text = text;
	}

	public boolean isEmpty() {
		return (text == null) || (text.isEmpty());
	}

	public String getText() {
		return text;
	}
}
