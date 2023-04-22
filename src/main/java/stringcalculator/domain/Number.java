package stringcalculator.domain;

public class Number {

	private final int number;

	public Number(String number) {
		this.number = this.toInt(number);
	}

	public String add(String number) {
		return toString(this.number + toInt(number));
	}

	public String subtract(String number) {
		return toString(this.number - toInt(number));
	}

	public String multiply(String number) {
		return toString(this.number * toInt(number));
	}

	public String divide(String number) {
		if (number.equals("0")) {
			throw new IllegalArgumentException("나누려는 숫자는 0일 수 없습니다.");
		}

		return toString(this.number / toInt(number));
	}

	private int toInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자는 정수만 입력 가능합니다.");
		}
	}

	private String toString(int number) {
		return String.valueOf(number);
	}
}
