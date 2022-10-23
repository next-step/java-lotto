package calculator.domain;

import static java.lang.System.*;

public class StringCalculator implements Calculator {

	@Override
	public int calculate(String expression) {
		final ExpressionArguments expressionArguments;
		try {
			expressionArguments = new ExpressionArguments(expression);
			return getResult(expressionArguments);
		} catch (Exception exception) {
			out.println(exception.getMessage());
			throw exception;
		}
	}

	private int getResult(ExpressionArguments expressionArguments) {
		int result = expressionArguments.getFirstOperand();
		for (int i = 0; i < expressionArguments.getOperatorsSize(); i++) {
			result = expressionArguments.getOperators()
				.get(i)
				.operate(result, expressionArguments.getOperands().get(i + 1).getNumber());
		}

		return result;
	}
}
