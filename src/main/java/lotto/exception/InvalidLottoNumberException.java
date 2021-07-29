package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

	public InvalidLottoNumberException(int number) {
		super(String.format("유효하지 않은 로또 번호입니다: %d", number));
	}
}
