package study;

public class StringCalculatorNumber {

	private int number;

	public StringCalculatorNumber(int number) {
		validationNumber(number);
		this.number = number;
	}

	public StringCalculatorNumber add(int number) {
		validationNumber(number);
		this.number += number;
		return this;
	}

	public int get() {
		return this.number;
	}

	private void validationNumber(int number) {
		if (number < 0) {
			throw new RuntimeException("음수는 허용되지 않습니다.");
		}
	}

}
