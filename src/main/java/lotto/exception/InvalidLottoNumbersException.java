package lotto.exception;

public class InvalidLottoNumbersException extends RuntimeException {

  public static final String EXCEPTION_MESSAGE = " 개의 로또 번호가 필요합니다.";

  public InvalidLottoNumbersException(int requiredCount) {
    super(requiredCount + EXCEPTION_MESSAGE);
  }
}
