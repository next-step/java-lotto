package lotto.exception;

public class DuplicateBonusNumberException extends RuntimeException {

    private static final String DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE = "보너스번호가 당첨번호와 중복됩니다.";

    public DuplicateBonusNumberException() {
        super(DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE);
    }
}
