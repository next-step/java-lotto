package lotto.exception;

public class InvalidLottoNumberSizeException extends RuntimeException {

	public InvalidLottoNumberSizeException() {
		super("로또 번호의 총 개수는 6개여야 합니다.");
	}
}
