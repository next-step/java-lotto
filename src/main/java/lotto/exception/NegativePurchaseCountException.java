package lotto.exception;

public class NegativePurchaseCountException extends IllegalArgumentException {

  public NegativePurchaseCountException() {
    super("구매할 개수는 음수값이 될수 없습니다.");
  }
}
