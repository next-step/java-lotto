package lotto.exception;

public class InvalidNumberBoundException extends RuntimeException {

    public static final String NUMBER_BOUND_ERROR_MESSAGE = "Bound Must be grater than size";

    public InvalidNumberBoundException() {
        super(NUMBER_BOUND_ERROR_MESSAGE);
    }
}
