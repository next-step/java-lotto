package calculator.exception;

public class ZeroDivideException extends RuntimeException {

	public ZeroDivideException(ErrorMessage message) {
		super(message.getMessage());
	}
}
