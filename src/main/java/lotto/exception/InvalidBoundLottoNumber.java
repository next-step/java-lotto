package lotto.exception;

public class InvalidBoundLottoNumber extends IndexOutOfBoundsException {

    private static final String MESSAGE = "로또 숫자는 1 ~ 45 사이의 값만 가능합니다.";

    public InvalidBoundLottoNumber() {
        super(MESSAGE);
    }
}
