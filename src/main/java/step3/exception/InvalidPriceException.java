package step3.exception;

public class InvalidPriceException extends RuntimeException {
  public InvalidPriceException(String errorMessage) {
    super(errorMessage);
  }
}
