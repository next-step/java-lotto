package lotto.exception;

public class LottoGameException extends RuntimeException {

  public LottoGameException(String message) {
    super(message);
  }

  public LottoGameException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
