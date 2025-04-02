package step4.lotto.exception;

public class MoneyInvalidValueException extends MoneyException {

    public static final String MESSAGE = "금액의 값은 0 이상이어야 합니다.";

    public MoneyInvalidValueException() {
        super(MESSAGE);
    }

}
