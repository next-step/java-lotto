package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

  public static final int LOTTO_PRICE = 1000;

  private final long amount;

  public static Money from(String amount) {
    return from(Long.parseLong(amount));
  }

  public static Money from(long amount) {
    return new Money(amount);
  }

  private Money(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
    }
    this.amount = amount;
  }

  public long countLotto() {
    return amount / LOTTO_PRICE;
  }

  public double rateOfReturn(Money prize) {
    return BigDecimal.valueOf(prize.getAmount())
        .divide(BigDecimal.valueOf(amount), 2, RoundingMode.FLOOR)
        .doubleValue();
  }

  public long getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return amount == money.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return String.valueOf(amount);
  }
}
