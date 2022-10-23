package calculator.domain;

import calculator.exception.ErrorMessage;
import calculator.exception.OperandNumberFormatException;

public class Operand {
	private final int number;

	public Operand(String value) {
		try {
			number = Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			throw new OperandNumberFormatException(ErrorMessage.OPERAND_MUST_BE_NUMBER, value);
		}
	}

	public int getNumber() {
		return number;
	}
}
