package lotto.exception;

public class ExceedPurchaseCountException extends IllegalArgumentException {

  public ExceedPurchaseCountException() {
    super("구매개수를 초과하였습니다.");
  }
}
