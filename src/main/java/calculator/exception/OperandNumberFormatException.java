package calculator.exception;

import java.text.MessageFormat;

public class OperandNumberFormatException extends NumberFormatException {

	public OperandNumberFormatException(ErrorMessage errorMessage, String arg) {
		super(MessageFormat.format(errorMessage.getMessage(), arg));
	}
}
