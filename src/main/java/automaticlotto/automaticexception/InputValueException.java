package automaticlotto.automaticexception;

public class InputValueException extends RuntimeException {

    public InputValueException() {

    }

    public InputValueException(String message) {
        super(message);
    }
}
