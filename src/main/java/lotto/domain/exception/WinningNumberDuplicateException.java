package lotto.domain.exception;

public final class WinningNumberDuplicateException extends IllegalArgumentException {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "당첨번호와 보너스번호가 중복되었습니다.";

    public WinningNumberDuplicateException() {
        super(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

}
