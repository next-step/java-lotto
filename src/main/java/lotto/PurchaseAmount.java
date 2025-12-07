package lotto;

public class PurchaseAmount {

  private static final int PRICE_PER_LOTTO = 1000;
  private static final String ERROR_INVALID_PURCHASE_AMOUNT =
      "금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.";

  private final int value;

  public PurchaseAmount(int value) {
    validate(value);
    this.value = value;
  }

  public int value() {
    return value;
  }

  public int ticketCount() {
    return value / PRICE_PER_LOTTO;
  }

  public int autoCount(ManualLottoCount manualCount) {
    return ticketCount() - manualCount.count();
  }

  private static void validate(int amount) {
    if (amount < PRICE_PER_LOTTO || amount % PRICE_PER_LOTTO != 0) {
      throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
    }
  }
}
