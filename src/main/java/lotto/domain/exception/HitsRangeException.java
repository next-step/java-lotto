package lotto.domain.exception;

public final class HitsRangeException extends IllegalArgumentException {

    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "맞춘 횟수는 0에서 6 사이여야 합니다.";

    public HitsRangeException() {
        super(OUT_OF_BOUNDS_ERROR_MESSAGE);
    }

}
