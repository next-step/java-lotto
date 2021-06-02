package kht2199.lotto.exception.input;

import kht2199.lotto.exception.DomainException;

/**
 * @author heetaek.kim
 */
public class InvalidInputException extends DomainException {

	private final InvalidInputError error;

	public InvalidInputException(InvalidInputError error) {
		this.error = error;
	}

	public InvalidInputException(InvalidInputError error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public InvalidInputError getError() {
		return error;
	}
}
