package calculator;

public class NationalNumber {

	private final int value;

	public NationalNumber(String value) {
		this.value = Integer.parseInt(value);

		validate();
	}

	private void validate() {
		if (value < 0) {
			throw new IllegalArgumentException("양수만 입력이 가능합니다.");
		}
	}

	public int getValue() {
		return value;
	}
}
