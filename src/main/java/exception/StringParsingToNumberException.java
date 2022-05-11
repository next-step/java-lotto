package exception;

public class StringParsingToNumberException extends IllegalArgumentException {
	public StringParsingToNumberException(String message) {
		super(message);
	}
}
