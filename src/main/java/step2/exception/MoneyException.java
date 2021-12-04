package step2.exception;

public class MoneyException extends IllegalArgumentException {

    public enum ErrorCode {
        MONEY_NOT_ZERO("금액을 0 이상 입력해주세요."),
        ;
        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }
    };

    public MoneyException(String s) {
        super(s);
    }

    public MoneyException(ErrorCode ex) {
        super(ex.message);
    }
}
