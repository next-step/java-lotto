package lotto.exceptions;

public class InvalidLottoNumberLengthException extends RuntimeException {
	public InvalidLottoNumberLengthException() {
		super("로또번호는 총 6개여야 합니다");
	}
}
