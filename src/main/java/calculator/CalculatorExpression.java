package calculator;

import java.util.List;
import java.util.Objects;

public class CalculatorExpression {
	private final String expression;

	public CalculatorExpression(String expression) {
		this.expression = expression;
	}

	public CalculatorNumber resultNumber(CalculatorDelimiter calculatorDelimiter) {
		List<String> splintedNumbers = calculatorDelimiter.operate(this.expression);
		CalculatorNumbers numbers = new CalculatorNumbers(splintedNumbers);
		return numbers.sumAll();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CalculatorExpression that = (CalculatorExpression)o;
		return Objects.equals(expression, that.expression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expression);
	}
}
