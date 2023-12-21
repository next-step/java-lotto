package calculator.domain;

import java.util.Objects;

public class Number {
	private final int number;

	public Number(int input) {
		number = input;
	}

	public int number(){
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
