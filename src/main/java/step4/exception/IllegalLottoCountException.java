package step4.exception;

public class IllegalLottoCountException extends RuntimeException {
    public IllegalLottoCountException() {
        super();
    }

    public IllegalLottoCountException(String message) {
        super(message);
    }
}
