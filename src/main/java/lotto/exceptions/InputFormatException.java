package lotto.exceptions;

public class InputFormatException extends RuntimeException {

    private static final String INPUTFORMAT_WARNING = "It's wrong input values";

    public InputFormatException() {
        super(INPUTFORMAT_WARNING);
    }
}
