package lotto.domain.exception;

public final class NumberRangeException extends IllegalArgumentException {

    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "1부터 45 사이의 숫자를 등록해야 합니다.";

    public NumberRangeException() {
        super(OUT_OF_BOUNDS_ERROR_MESSAGE);
    }

}
