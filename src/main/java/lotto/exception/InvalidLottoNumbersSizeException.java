package lotto.exception;

public class InvalidLottoNumbersSizeException extends RuntimeException {

	private static final String MESSAGE_FORMAT = "로또 티켓당 6개의 번호만 가질 수 있습니다. (현재: %d개)";

	public InvalidLottoNumbersSizeException(int currentNumbersSize) {
		super(String.format(MESSAGE_FORMAT, currentNumbersSize));
	}
}
