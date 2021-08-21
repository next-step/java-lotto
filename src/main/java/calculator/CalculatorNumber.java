package calculator;

import java.util.Objects;

public class CalculatorNumber {
	public static final String DO_NOT_USE_NEGATIVE_NUMBER = "음수는 사용할 수 업습니다.";
	public static final String DO_NOT_USE_ILLEGAL_PARAM = "숫자가 아닌 값은 사용할 수 없습니다.";
	private final int number;

	public CalculatorNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(DO_NOT_USE_NEGATIVE_NUMBER);
		}
		this.number = number;
	}

	public CalculatorNumber(String number) {
		try {
			this.number = Integer.parseInt(number);
		} catch (Exception e) {
			throw new IllegalArgumentException(DO_NOT_USE_ILLEGAL_PARAM);
		}
	}

	public CalculatorNumber add(CalculatorNumber other) {
		return new CalculatorNumber(this.number + other.number);
	}

	public int ToInteger() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CalculatorNumber that = (CalculatorNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
