package study.lottogame.domain;

import java.util.Objects;

public class Money {

  private int money;

  public Money(final int money) {
    if (money < 0) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다");
    }

    this.money = money;
  }

  public Money addMoney(Money money) {
    return new Money(this.money + money.getMoney());
  }

  public double getMoneyRate(Money money) {
    long percent = Math.round((this.money * 100.0) / money.getMoney());
    return percent / 100.0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money1 = (Money) o;
    return money == money1.money;
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }

  public int getMoney() {
    return money;
  }
}
