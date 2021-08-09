package lotto.exception;

/*
사용자가 로또 번호를 잘못 입력 했을때 발생하는 예외.
 */
public class InvalidWinningNumDuplicateException extends RuntimeException {
    private static final String INVALID_WINNING_NUM_DUPLICATE = "중복된 로또 번호를 입력.";

    public InvalidWinningNumDuplicateException() {
        super(INVALID_WINNING_NUM_DUPLICATE);
    }
}
