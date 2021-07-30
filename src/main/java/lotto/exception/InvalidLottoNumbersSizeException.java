package lotto.exception;

public class InvalidLottoNumbersSizeException extends RuntimeException {

	private static final String MESSAGE = "로또 티켓당 6개의 번호만 가질 수 있습니다.";

	public InvalidLottoNumbersSizeException() {
		super(MESSAGE);
	}
}
