package Calculator.exception;

public class OnlyNumberException extends RuntimeException {

    public OnlyNumberException() {
    }

    public OnlyNumberException(String msg) {
        super(msg);
    }
}
