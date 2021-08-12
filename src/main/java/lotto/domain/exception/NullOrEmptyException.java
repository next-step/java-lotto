package lotto.domain.exception;

public final class NullOrEmptyException extends IllegalArgumentException {

    private static final String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "값이 null이거나 비어있습니다.";

    public NullOrEmptyException() {
        super(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
    }

}
