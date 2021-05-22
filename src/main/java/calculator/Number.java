package calculator;

public class Number {

	private int value;

	Number(String text) {
		int num = Integer.parseInt(text);

		if (num < 0) {
			throw new RuntimeException();
		}
		this.value = num;
	}

	public int value() {
		return value;
	}
}
