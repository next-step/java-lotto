package step1.exception;

public class StringAdderException extends RuntimeException{

	public StringAdderException(String message) {
		super(message);
	}

	public StringAdderException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
