package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

  private final BigDecimal amount;

  public static Money wons(String amount) {
    return new Money(BigDecimal.valueOf(Long.parseLong(amount)));
  }

  public static Money wons(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money divide(double divisor) {
    return new Money(amount.divide(BigDecimal.valueOf(divisor), 2, RoundingMode.DOWN));
  }

  public Long longValue() {
    return amount.longValue();
  }

  public Double doubleValue() {
    return amount.doubleValue();
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof Money)) {
      return false;
    }

    Money other = (Money) object;
    return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
  }

  public int hashCode() {
    return Objects.hashCode(amount);
  }

  public String toString() {
    return amount.toString() + "원";
  }
}
