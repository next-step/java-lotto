package lotto.exception;

public class InvalidRangeOfLottoNumException extends RuntimeException {
	public InvalidRangeOfLottoNumException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
	}
}
