package step4.exception;

public class IllegalLottoBonusNumberException extends RuntimeException {
    public IllegalLottoBonusNumberException() {
        super();
    }

    public IllegalLottoBonusNumberException(String message) {
        super(message);
    }
}
