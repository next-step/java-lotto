package lotto.exception;

public class LottoNumberException extends RuntimeException {

  private static final String MESSAGE = "1부터 45사이의 숫자를 입력해주세요. %d의 숫자는 입력하실 수 없습니다.";

  public LottoNumberException(int value) {
    super(String.format(MESSAGE, value));
  }
}
