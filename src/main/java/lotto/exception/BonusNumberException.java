package lotto.exception;

public class BonusNumberException extends RuntimeException {
    public static final String BONUS_NUMBER_EXCEPTION = "보너스 숫자를 잘못 입력하셨습니다.";

    public BonusNumberException() {
        super(BONUS_NUMBER_EXCEPTION);
    }
}
