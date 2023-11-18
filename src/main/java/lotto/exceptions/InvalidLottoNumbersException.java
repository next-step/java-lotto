package lotto.exceptions;

public class InvalidLottoNumbersException extends RuntimeException {

    public InvalidLottoNumbersException() {
        super("입력값이 유효하지 않습니다. ex) 1, 2, 3, 4, 5, 6");
    }
}
