package lotto.exception;

public class LottoLengthException extends RuntimeException {

  private static final String MESSAGE = "로또의 자릿수는 6자리입니다.";

  public LottoLengthException() {
    super(MESSAGE);
  }
}
