package lotto.exception;

public class InvalidLottNumberException extends IllegalArgumentException {
    private static final String WRONG_LOTTO_NUMBER_MESSAGE = "(%s): 잘못된 번호입니다.";

    public InvalidLottNumberException(int wrongInput) {
        super(String.format(WRONG_LOTTO_NUMBER_MESSAGE, wrongInput));
    }
}
