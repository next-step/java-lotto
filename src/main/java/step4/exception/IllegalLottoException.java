package step4.exception;

public class IllegalLottoException extends RuntimeException {
    public IllegalLottoException() {
        super();
    }

    public IllegalLottoException(String message) {
        super(message);
    }
}
