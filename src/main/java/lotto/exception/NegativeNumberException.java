package lotto.exception;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException(int value) {
        super(String.format(ErrorMessage.NOT_ALLOW_NEGATIVE_NUMBER, value));
    }
}
