package lotto.exception;
/*
사용자가 당첨 번호의 길이를 잘못 입력했을때 발생하는 예외.
 */
public class InvalidWinningNumLengthException extends RuntimeException {
    private static final String INVALID_WINNING_LENGTH = "당첨 번호를 잘못 입력 했습니다.";

    public InvalidWinningNumLengthException() {
        super(INVALID_WINNING_LENGTH);
    }
}
