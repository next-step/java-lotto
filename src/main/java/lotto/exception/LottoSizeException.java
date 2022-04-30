package lotto.exception;

public class LottoSizeException extends RuntimeException {

  private static final String MESSAGE = "구입한 로또가 존재하지 않습니다.";

  public LottoSizeException() {
    super(MESSAGE);
  }
}
