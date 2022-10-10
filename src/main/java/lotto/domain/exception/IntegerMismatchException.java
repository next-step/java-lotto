package lotto.domain.exception;

public class IntegerMismatchException extends RuntimeException {

    public IntegerMismatchException() {
        super("숫자를 입력하세요.");
    }

}
