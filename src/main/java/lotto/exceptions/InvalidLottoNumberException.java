package lotto.exceptions;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public InvalidLottoNumberException(int number) {
        super("로또 숫자(1 ~ 45)가 아닙니다. 입력값: " + number);
    }
}
