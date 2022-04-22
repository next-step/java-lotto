package Calculator.exception;

public class NotFoundOperatorException extends RuntimeException {

    public NotFoundOperatorException() {
    }

    public NotFoundOperatorException(String msg) {
        super(msg);
    }
}
