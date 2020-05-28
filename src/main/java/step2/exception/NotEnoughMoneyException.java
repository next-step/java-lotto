package step2.exception;

public class NotEnoughMoneyException extends RuntimeException {

    private final static String DEFAULT_MESSAGE = "티켓을 구매 할 금액이 충분하지 않습니다.";

    public NotEnoughMoneyException() {
        super(DEFAULT_MESSAGE);
    }
}
