package step3.exception;

public class NotEnoughInitMoneyException extends RuntimeException {

    public static final String message = "초기 자금은 1000원 이상 이여야 합니다.";

    public NotEnoughInitMoneyException() {
        super(message);
    }
}
