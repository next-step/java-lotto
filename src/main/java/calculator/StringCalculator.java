package calculator;

import static java.lang.System.*;

import java.util.stream.IntStream;

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
		return IntStream.range(0, expressionArguments.getOperatorsSize())
			.reduce(expressionArguments.getFirstOperand(),
				(preIdx, postIdx) ->
					expressionArguments.getOperators().get(postIdx)
						.operate(expressionArguments.getOperands().get(preIdx),
							expressionArguments.getOperands().get(postIdx))
			);
	}
}
