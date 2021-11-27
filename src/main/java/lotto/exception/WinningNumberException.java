package lotto.exception;

public class WinningNumberException extends RuntimeException {
    private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "당첨번호가 알맞지 않습니다.";

    public WinningNumberException() {
        super(WINNING_NUMBER_EXCEPTION_MESSAGE);
    }
}
