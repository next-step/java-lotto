package lotto.dto;

import java.util.Objects;

public class OrderSheet {

  private final long purchasingAmount;

  public OrderSheet(long purchasingAmount) {
    this.purchasingAmount = purchasingAmount;
  }

  public long getPurchasingAmount() {
    return purchasingAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderSheet that = (OrderSheet) o;
    return purchasingAmount == that.purchasingAmount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasingAmount);
  }
}
