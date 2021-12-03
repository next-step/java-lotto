package domain;

import java.util.Objects;

import static common.Constants.ZERO;

public class Money {

  private static final String MONEY_CANNOT_BE_NEGATIVE = "Money는 음수값을 가질 수 없습니다.";
  private static final String MONEY_CANNOT_BE_DIVIDED_BY_ZERO = "분모는 0이 될 수 없습니다.";

  private final int value;

  public Money(int value) {
    checkNotNegative(value);
    this.value = value;
  }

  private void checkNotNegative(int value) {
    if (value < ZERO) {
      throw new IllegalArgumentException(MONEY_CANNOT_BE_NEGATIVE);
    }
  }

  public boolean isLowerThan(Money anotherMoney) {
    return this.value < anotherMoney.value;
  }
  
  public int quotient(Money anotherMoney) {
    checkZeroWhenDivision(anotherMoney);
    return this.value / anotherMoney.value;
  }

  private void checkZeroWhenDivision(Money money) {
    if (money.value == ZERO) {
      throw new IllegalArgumentException(MONEY_CANNOT_BE_DIVIDED_BY_ZERO);
    }
  }

  public Money subtract(Money anotherMoney) {
    return new Money(this.value - anotherMoney.value);
  }

  public Money multiply(int weight) {
    return new Money(weight * this.value);
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object anotherMoney) {
    if (this == anotherMoney) return true;
    if (anotherMoney == null || getClass() != anotherMoney.getClass()) return false;
    Money money = (Money) anotherMoney;
    return value == money.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
