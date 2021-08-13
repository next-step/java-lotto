package lotto.domain.exception;

public final class NumberCountException extends IllegalArgumentException {

    private static final String IS_NULL_OR_NOT_SIX_ERROR_MESSAGE = "6개의 숫자를 등록해야 합니다.";

    public NumberCountException() {
        super(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
    }

}
