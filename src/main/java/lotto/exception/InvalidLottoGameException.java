package lotto.exception;

public class InvalidLottoGameException extends RuntimeException {

  public static final String EXCEPTION_MESSAGE = " 개의 숫자가 입력되어야 합니다.";

  public InvalidLottoGameException(int requiredCount) {
    super(requiredCount + EXCEPTION_MESSAGE);
  }
}
