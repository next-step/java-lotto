package exception;

import type.StringAddCalculatorExceptionType;

public class StringAddCalculatorException extends RuntimeException{

	private StringAddCalculatorException(final StringAddCalculatorExceptionType code) {
		super(code.getMessage());
	}

	public static StringAddCalculatorException of(StringAddCalculatorExceptionType code) {
		return new StringAddCalculatorException(code);
	}
}
