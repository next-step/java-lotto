package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operator {

	private static final List<String> KIND = Arrays.asList("+", "-", "*", "/");
	private final String operator;

	public Operator(String operator) {
		if (KIND.contains(operator) == false) {
			throw new IllegalArgumentException("올바르지 않은 사칙연산입니다.");
		}

		this.operator = operator;
	}

	public boolean isPlus() {
		return this.operator.equals("+");
	}

	public boolean isMinus() {
		return this.operator.equals("-");
	}

	public boolean isMultiply() {
		return this.operator.equals("*");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operator operator1 = (Operator)o;
		return Objects.equals(operator, operator1.operator);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operator);
	}
}
