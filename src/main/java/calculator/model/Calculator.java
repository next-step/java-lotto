package calculator.model;

import java.util.Objects;

public class Calculator {

	private final Expression expression;

	public Calculator(Expression expression) {

		this.expression = expression;
	}

	public int getSum() {

		return this.expression.sum();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Calculator that = (Calculator)o;
		return Objects.equals(expression, that.expression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expression);
	}
}
