package lotto.exception;

import java.text.MessageFormat;

import calculator.exception.ErrorMessage;

public class MoneyNegativeException extends RuntimeException {

	public MoneyNegativeException(ErrorMessage message, String arg) {
		super(MessageFormat.format(message.getMessage(), arg));
	}
}
