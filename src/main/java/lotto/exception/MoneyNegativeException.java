package lotto.exception;

public class MoneyNegativeException extends RuntimeException {

	public MoneyNegativeException(ErrorMessage message) {
		super(message.getMessage());
	}
}
