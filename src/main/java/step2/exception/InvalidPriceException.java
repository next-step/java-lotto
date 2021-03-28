package step2.exception;

public class InvalidPriceException extends RuntimeException{
  public InvalidPriceException(String errorMessage) {
    super(errorMessage);
  }
}
