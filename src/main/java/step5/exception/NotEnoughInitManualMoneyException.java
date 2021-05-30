package step5.exception;

public class NotEnoughInitManualMoneyException extends RuntimeException{

    public static final String MESSAGE = "수동으로 구입할 로또 금액이 모자랍니다.";

    public NotEnoughInitManualMoneyException() {
        super(MESSAGE);
    }
}
