package step2.exception;

public class InvalidLottoNumberException extends RuntimeException {
  public InvalidLottoNumberException(String message) {
    super(message);
  }
}
