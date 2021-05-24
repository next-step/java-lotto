package calculator;

public class Number {

	private int value;

	Number(String text) {
		int num = Integer.parseInt(text);

		if (num < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
		}
		this.value = num;
	}

	public int value() {
		return value;
	}
}
