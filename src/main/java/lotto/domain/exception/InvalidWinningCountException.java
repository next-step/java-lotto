package lotto.domain.exception;

public class InvalidWinningCountException extends RuntimeException {
    private static final String MESSAGE = "잘못된 당첨 숫자 개수입니다.";

    public InvalidWinningCountException() {
        super(MESSAGE);
    }
}
