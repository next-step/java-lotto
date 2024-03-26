package calculator.domain;

public class Number {
	private final int number;

	public Number(int number) {
		this.number = number;
	}

	public Number(String number) {
		try {
			this.number = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("숫자를 입력해야 합니다.");
		}
	}

	public int getNumber() {
		return number;
	}
}
