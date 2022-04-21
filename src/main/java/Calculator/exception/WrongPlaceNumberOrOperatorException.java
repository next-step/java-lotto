package Calculator.exception;

public class WrongPlaceNumberOrOperatorException extends RuntimeException {

    public WrongPlaceNumberOrOperatorException() {
    }

    public WrongPlaceNumberOrOperatorException(String msg) {
        super(msg);
    }
}
