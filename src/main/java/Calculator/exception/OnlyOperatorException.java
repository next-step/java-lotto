package Calculator.exception;

public class OnlyOperatorException extends RuntimeException {

    public OnlyOperatorException() {
    }

    public OnlyOperatorException(String msg) {
        super(msg);
    }
}
