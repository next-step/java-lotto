package lotto.domain.exception;

public class InvalidLottoNumberException extends RuntimeException {

    public InvalidLottoNumberException(int firstNumber, int lastNumber) {
        super("로또 번호는 " + firstNumber + " ~ " + lastNumber + " 사이입니다.");
    }

}
