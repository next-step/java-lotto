package calculator;

import java.util.Objects;

public class ParsedNumber {

	private final int number;
	private final int DEFAULT_NUMBER = 0;

	public ParsedNumber() {
		this.number = DEFAULT_NUMBER;
	}

	public ParsedNumber(String number) {
		this.number = parseInt(number);
	}

	private int parseInt(String number) {
		int parsedNumber = Integer.parseInt(number);
		if (isNegativeNumber(parsedNumber)) {
			throw new RuntimeException();
		}
		return parsedNumber;
	}

	private boolean isNegativeNumber(int number) {
		return number < 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ParsedNumber))
			return false;
		ParsedNumber that = (ParsedNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, DEFAULT_NUMBER);
	}

	public int getNumber() {
		return this.number;
	}
}
