package lotto.exception;

public class InvalidLottoNumberQuantityException extends RuntimeException {

	public InvalidLottoNumberQuantityException(ErrorMessage message) {
		super(message.getMessage());
	}
}
