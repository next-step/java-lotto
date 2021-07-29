package lotto.exception;

public class InvalidLottoNumberSizeException extends RuntimeException {

	private static final String MESSAGE = "로또 번호의 총 개수는 6개여야 합니다.";

	public InvalidLottoNumberSizeException() {
		super(MESSAGE);
	}
}
