package lotto.exception;

public class InvalidNumbersException extends IllegalArgumentException {
    private static final String WRONG_NUMBERS_MESSAGE = "(%s): 잘못된 당첨 번호입니다.";

    public InvalidNumbersException(String wrongInput) {
        super(String.format(WRONG_NUMBERS_MESSAGE, wrongInput));
    }
}
