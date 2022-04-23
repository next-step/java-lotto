package lotto;

import java.util.Objects;

public final class Guest {
  private final Money money;

  public Guest(int money) {
    this.money = new Money(money);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Guest guest = (Guest) o;
    return Objects.equals(money, guest.money);
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }
}
