package nextstep.calculator;

public class Number {

	private final int number;

	public Number(final String value) {
		try {
			this.number = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효하지 않은 포맷입니다. number = " + value);
		}
	}

	private Number(final int number) {
		this.number = number;
	}

	public Number plus(Number b) {
		return new Number(number + b.number);
	}

	public Number minus(Number b) {
		return new Number(number - b.number);
	}

	public Number multiply(Number b) {
		return new Number(number * b.number);
	}

	public Number divide(Number b) {
		return new Number(number / b.number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() != o.getClass()) {return false;}

		Number number1 = (Number) o;

		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return number;
	}
}
