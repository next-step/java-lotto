package lotto.exception;

public class WinningNumberException extends RuntimeException {
    private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "잘못된 당첨번호를 입력하였습니다.";

    public WinningNumberException() {
        super(WINNING_NUMBER_EXCEPTION_MESSAGE);
    }
}
