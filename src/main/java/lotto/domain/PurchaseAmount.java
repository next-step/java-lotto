package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

  private static final int PRICE_PER_TICKET = 1000;
  private static final int MIN_PURCHASE_AMOUNT = 0;
  private static final int CORRECT_REMAINDER_VALUE = 0;
  public static final String INVALID_PURCHASE_AMOUNT_INPUT = "해당 금액으로는 로또 구매가 불가능합니다. 금액을 다시 확인해주세요. input: %s";
  public static final String INVALID_MANUAL_PURCHASE_COUNT_INPUT = "구매 금액으로 구매 불가능한 수동 로또 개수가 들어왔습니다. 구입 금액: %s, 수동 구매 요청 갯수: %s";

  private final int autoPurchaseAmount;
  private final int manualPurchaseAmount;

  private PurchaseAmount(int autoPurchaseAmount, int manualPurchaseAmount) {
    this.autoPurchaseAmount = autoPurchaseAmount;
    this.manualPurchaseAmount = manualPurchaseAmount;
  }

  public static PurchaseAmount of(int totalPurchaseAmount, int manualPurchaseCount) {
    validate(totalPurchaseAmount, manualPurchaseCount);
    int manualPurchaseAmount = manualPurchaseCount * PRICE_PER_TICKET;
    int autoPurchaseAmount = totalPurchaseAmount - manualPurchaseAmount;
    return new PurchaseAmount(autoPurchaseAmount, manualPurchaseAmount);
  }

  public boolean isSame(int amount) {
    return (this.autoPurchaseAmount + this.manualPurchaseAmount) == amount;
  }

  public int amount() {
    return this.autoPurchaseAmount + this.manualPurchaseAmount;
  }

  private static void validate(int totalPurchaseAmount, int manualPurchaseCount) {
    if (totalPurchaseAmount <= MIN_PURCHASE_AMOUNT || totalPurchaseAmount % PRICE_PER_TICKET != CORRECT_REMAINDER_VALUE) {
      throw new IllegalArgumentException(String.format(INVALID_PURCHASE_AMOUNT_INPUT, totalPurchaseAmount));
    }

    if (manualPurchaseCount < MIN_PURCHASE_AMOUNT || totalPurchaseAmount < manualPurchaseCount * PRICE_PER_TICKET) {
      throw new IllegalArgumentException(String.format(INVALID_MANUAL_PURCHASE_COUNT_INPUT, totalPurchaseAmount, manualPurchaseCount));
    }
  }

  public int autoTicketCount() {
    if (autoPurchaseAmount == MIN_PURCHASE_AMOUNT) {
      return MIN_PURCHASE_AMOUNT;
    }
    return this.autoPurchaseAmount / PRICE_PER_TICKET;
  }

  public int allTicketCount() {
    if (autoPurchaseAmount == MIN_PURCHASE_AMOUNT) {
      return this.manualPurchaseAmount / PRICE_PER_TICKET;
    }

    if (manualPurchaseAmount == MIN_PURCHASE_AMOUNT) {
      return this.autoPurchaseAmount / PRICE_PER_TICKET;
    }

    return (this.autoPurchaseAmount / PRICE_PER_TICKET) + (this.manualPurchaseAmount / PRICE_PER_TICKET);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseAmount that = (PurchaseAmount) o;
    return autoPurchaseAmount == that.autoPurchaseAmount && manualPurchaseAmount == that.manualPurchaseAmount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoPurchaseAmount, manualPurchaseAmount);
  }
}
