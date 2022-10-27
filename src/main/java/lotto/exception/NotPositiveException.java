package lotto.exception;

public class NotPositiveException extends RuntimeException {

    public NotPositiveException() {
        super("0 이상의 숫자를 입력하세요.");
    }
}
