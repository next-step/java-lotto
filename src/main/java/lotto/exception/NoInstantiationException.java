package lotto.exception;

public class NoInstantiationException extends RuntimeException {

    private static final String MESSAGE = "인스턴스화 금지된 객체 입니다 : %s";

    public NoInstantiationException(final String message) {
        super(String.format(MESSAGE, message));
    }
}
