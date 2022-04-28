package lotto.exception;

public class LottoNegativeException extends RuntimeException {

  private static final String MESSAGE = "로또는 0이하의 숫자를 입력할 수 없습니다.";

  public LottoNegativeException() {
    super(MESSAGE);
  }
}
