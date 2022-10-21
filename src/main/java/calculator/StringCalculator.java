package calculator;

public class StringCalculator implements Calculator {

	@Override
	public int calculate(String expression) {
		final ExpressionArguments expressionArguments = new ExpressionArguments(expression);
		return 0;
	}
}
