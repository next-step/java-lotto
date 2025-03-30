package step4.lotto.exception;

public class MoneyInvalidFormatException extends MoneyException{

    public static final String MESSAGE = "금액은 0과 양의 정수만 입력 가능합니다.";

    public MoneyInvalidFormatException() {
        super(MESSAGE);
    }

}
