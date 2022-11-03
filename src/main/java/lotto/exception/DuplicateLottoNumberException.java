package lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {
	public DuplicateLottoNumberException(ErrorMessage message) {
		super(message.getMessage());
	}
}
