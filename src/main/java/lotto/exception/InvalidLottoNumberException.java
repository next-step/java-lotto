package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

  private static final String EXCEPTION_MESSAGE = " 는 정상적인 로또 번호가 아닙니다";

  public InvalidLottoNumberException(String value) {
    super(value + EXCEPTION_MESSAGE);
  }
}
