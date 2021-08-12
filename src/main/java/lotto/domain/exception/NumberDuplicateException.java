package lotto.domain.exception;

public final class NumberDuplicateException extends IllegalArgumentException {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";

    public NumberDuplicateException() {
        super(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

}
