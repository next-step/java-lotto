package exception;

public class StringParsingToIntegerException extends IllegalArgumentException {
	public StringParsingToIntegerException(String message) {
		super(message);
	}
}
