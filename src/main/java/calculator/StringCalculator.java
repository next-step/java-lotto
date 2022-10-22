package calculator;

import static java.lang.System.*;

import calculator.exception.OperandNumberFormatException;
import calculator.exception.OperatorInvalidException;

public class StringCalculator implements Calculator {

	@Override
	public int calculate(String expression) {
		final ExpressionArguments expressionArguments;
		try {
			expressionArguments = new ExpressionArguments(expression);
		} catch (OperandNumberFormatException | OperatorInvalidException exception) {
			out.println(exception.getMessage());
		}
		return 0;
	}
}
