package lotto.exception;

public class InvalidMatchCountException extends RuntimeException {
	public InvalidMatchCountException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
	}
}
