package step2.exception;

public final class LottoShuffleNullPointerException extends RuntimeException {
    private final String message = "셔플 전략이 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
