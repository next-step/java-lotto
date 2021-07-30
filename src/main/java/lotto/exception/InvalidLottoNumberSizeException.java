package lotto.exception;

public class InvalidLottoNumberSizeException extends RuntimeException {

	private static final String MESSAGE_FORMAT = "로또 번호의 총 개수는 6개여야 합니다. (현재: %d개)";

	public InvalidLottoNumberSizeException(int currentLottoNumbers) {
		super(String.format(MESSAGE_FORMAT, currentLottoNumbers));
	}
}
