package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

	private static final String MESSAGE_FORMAT = "유효하지 않은 로또 번호입니다: %d";

	public InvalidLottoNumberException(int number) {
		super(String.format(MESSAGE_FORMAT, number));
	}
}
