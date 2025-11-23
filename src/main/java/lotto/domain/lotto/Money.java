package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

  private final BigDecimal amount;

  public Money(int amount) {
    validate(amount);
    this.amount = new BigDecimal(amount);
  }

  private Money(BigDecimal amount) {
    this.amount = amount;
  }

  private void validate(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("금액은 0이상이어야 합니다");
    }
  }

  public Money add(Money money) {
    return new Money(this.amount.add(money.amount));
  }

  public Money multiply(int multiplier) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(multiplier)));
  }

  public BigDecimal divideBy(Money divisor) {
    validateDivisor(divisor);
    return this.amount.divide(divisor.amount, 2, RoundingMode.HALF_UP);
  }

  public int divideForCount(Money divisor) {
    validateDivisor(divisor);
    return this.amount.divide(divisor.amount, 0, RoundingMode.DOWN).intValue();
  }

  private void validateDivisor(Money divisor) {
    if (divisor.amount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("몫은 0보다 커야 합니다");
    }
  }

  @Override
  public String toString() {
    return this.amount.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return Objects.equals(amount, money.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(amount);
  }
}
