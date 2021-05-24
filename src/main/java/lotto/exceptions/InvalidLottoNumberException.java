package lotto.exceptions;

public class InvalidLottoNumberException extends RuntimeException {
	public InvalidLottoNumberException() {
		super("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다");
	}
}
