package lotto.exception;

import calculator.exception.ErrorMessage;

public class InvalidMatchCountException extends RuntimeException {
	public InvalidMatchCountException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
	}
}
