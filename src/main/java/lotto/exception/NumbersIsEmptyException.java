package lotto.exception;

public class NumbersIsEmptyException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또 번호를 입력하세요";

    public NumbersIsEmptyException() {
        super(ERROR_MESSAGE);
    }
}
