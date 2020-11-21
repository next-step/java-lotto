package exception;

public class LackOfMoneyException extends IllegalArgumentException {
    public static final String MESSAGE = "1000원 이상 지불해야 로또를 살 수 있습니다.";

    public LackOfMoneyException() {
        super(MESSAGE);
    }
}
