package lotto.exceptions;

public class InvalidLottoNumberException extends RuntimeException {

    public InvalidLottoNumberException(int number) {
        super("로또 번호는 1부터 45까지의 숫자여야 합니다. 입력값 : " + number);
    }
}
