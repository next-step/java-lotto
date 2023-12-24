package calculator.controller;

import calculator.domain.Expression;
import calculator.domain.Digit;

public final class Calculator {
	public static Digit calculate(final Expression expression) {
		for (int i = 0; i < expression.operators().size(); i++) {
			expression.insertDigit(i + 1,
				expression.indexOfOperators(i).operate(expression.indexOfDigits(i),
					expression.indexOfDigits(i + 1)));
		}

		return expression.indexOfDigits(expression.operators().size());
	}

}
