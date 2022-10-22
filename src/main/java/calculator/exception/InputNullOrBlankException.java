package calculator.exception;

import java.text.MessageFormat;

public class InputNullOrBlankException extends IllegalArgumentException {

	public InputNullOrBlankException(ErrorMessage message, String arg) {
		super(MessageFormat.format(message.getMessage(), arg));
	}
}
