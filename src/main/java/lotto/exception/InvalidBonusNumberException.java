package lotto.exception;

public class InvalidBonusNumberException extends IllegalArgumentException {
    private static final String WRONG_BONUS_NUMBER_MESSAGE = "(%s): 잘못된 보너스 볼입니다.";

    public InvalidBonusNumberException(int wrongInput) {
        this(String.valueOf(wrongInput));
    }

    public InvalidBonusNumberException(String wrongInput) {
        super(String.format(WRONG_BONUS_NUMBER_MESSAGE, wrongInput));
    }
}
