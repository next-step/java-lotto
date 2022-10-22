package calculator.exception;

import java.text.MessageFormat;

public class OperatorInvalidException extends IllegalArgumentException {

	public OperatorInvalidException(ErrorMessage message, String arg) {
		super(MessageFormat.format(message.getMessage(), arg));
	}
}
