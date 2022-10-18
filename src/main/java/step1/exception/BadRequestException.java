package step1.exception;

public class BadRequestException extends IllegalArgumentException {

	public BadRequestException(String message) {
		super(message);
	}
}