package calculator.controller;

import calculator.domain.Addition;
import calculator.domain.Expression;
import calculator.domain.Digit;
import calculator.domain.Operation;

public class StringCalculator {
	public static Digit calculate(Expression expression) {
		Operation operation = new Addition();

		for (int i = 0; i < expression.operators().size(); i++) {
			expression.insertDigit(i + 1,
				operation.operation(expression.indexOfOperators(i)).operate(expression.indexOfDigits(i),
					expression.indexOfDigits(i + 1)));
		}

		return expression.indexOfDigits(expression.operators().size());
	}

}
