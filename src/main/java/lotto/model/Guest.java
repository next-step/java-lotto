package lotto.model;

import java.util.List;
import java.util.Objects;

public final class Guest {

  private final Money money;
  private final List<Lotto> allLottoList;

  public Guest(long money) {
    this(money, null);
  }

  public Guest(long money, List<Lotto> allLottoList) {
    this.money = new Money(money);
    this.allLottoList = allLottoList;
  }

  public Guest choiceProduct(Store store) {
    return new Guest(0,store.delivery(Long.parseLong(money.toString())));
  }

  public List<Lotto> hasAllLotto() {
    return allLottoList;
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
    return Objects.equals(money, guest.money) && Objects.equals(allLottoList,
        guest.allLottoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(money, allLottoList);
  }
}
