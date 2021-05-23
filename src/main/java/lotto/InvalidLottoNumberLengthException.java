package lotto;

public class InvalidLottoNumberLengthException extends RuntimeException {
	InvalidLottoNumberLengthException() {
		super("로또번호는 총 6개여야 합니다");
	}
}
