package calculator;

import java.util.Arrays;

import calculator.exception.ErrorMessage;
import calculator.exception.OperatorInvalidException;

public enum Operator {
	ADDITION("+"),
	SUBTRACTION("-"),
	MULTIPLICATION("*"),
	DIVISION("/");

	private final String symbol;

	Operator(String value) {
		if (!isValidSymbol(value)) {
			throw new OperatorInvalidException(ErrorMessage.INVALID_OPERATOR, value);
		}
		symbol = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public boolean isValidSymbol(String value) {
		return Arrays.stream(values())
			.anyMatch(
				operator -> operator.getSymbol().equals(value)
			);
	}
}
