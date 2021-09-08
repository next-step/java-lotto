package domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

	private Integer number;

	public Number(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Number number1 = (Number) o;
		return Objects.equals(number, number1.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int compareTo(Number number) {
		return this.number.compareTo(number.getNumber());
	}
}
