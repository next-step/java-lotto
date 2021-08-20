package calculator;

import java.util.List;

public class CalculatorExpression {
	public static final String ZERO = "0";
	private final String expression;

	public CalculatorExpression(String expression) {
		if (expression == null || expression.isEmpty()) {
			this.expression = ZERO;
			return;
		}
		this.expression = expression;
	}

	public CalculatorNumber resultNumber(CalculatorDelimiter calculatorDelimiter) {
		List<String> splintedNumbers = calculatorDelimiter.operate(this.expression);
		CalculatorNumbers numbers = new CalculatorNumbers(splintedNumbers);
		return numbers.sumAll();
	}
}
