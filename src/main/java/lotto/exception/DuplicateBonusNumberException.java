package lotto.exception;

public class DuplicateBonusNumberException extends RuntimeException {
	public DuplicateBonusNumberException(ErrorMessage message) {
		super(message.getMessage());
	}
}
