package lotto.exception;

public class IllegalSeparateException extends RuntimeException {
    public IllegalSeparateException() {
        super("구분자는 , 여야 합니다.");
    }
}
