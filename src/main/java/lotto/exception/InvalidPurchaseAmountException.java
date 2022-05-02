package lotto.exception;

public class InvalidPurchaseAmountException extends RuntimeException {

  public static final String EXCEPTION_MESSAGE = "로또 한장 이상을 구매해야 합니다.";

  public InvalidPurchaseAmountException() {
    super(EXCEPTION_MESSAGE);
  }
}
