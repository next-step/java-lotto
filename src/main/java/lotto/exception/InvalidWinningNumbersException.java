package lotto.exception;

public class InvalidWinningNumbersException extends RuntimeException {

  private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "6개의 중복되지 않는 숫자를 입력하세요.";

  public InvalidWinningNumbersException() {
        super(WINNING_NUMBER_EXCEPTION_MESSAGE);
    }
}
