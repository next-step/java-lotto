package step2.exception;

public class NotEnoughMoneyException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "금액이 부족합니다.";

    public NotEnoughMoneyException() {
        super(DEFAULT_MESSAGE);
    }
}
