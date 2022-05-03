package lotto.exception;

public class InvalidInputWinningNumberException extends RuntimeException {

    public static final String INVALID_WINNING_NUMBER_MESSAGE = "당첨번호 입력이 잘못되었습니다.";

    public InvalidInputWinningNumberException() {
        super(INVALID_WINNING_NUMBER_MESSAGE);
    }
}
