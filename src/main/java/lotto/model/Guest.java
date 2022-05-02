package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.exception.LottoSizeException;

public final class Guest {

  private final Money money;
  private final List<Lotto> allLotteryTickets;

  public Guest(long money) {
    this(money, null);
  }

  public Guest(long money, List<Lotto> allLotteryTickets) {
    this.money = new Money(money);
    this.allLotteryTickets = allLotteryTickets;
  }

  public Guest choiceProduct(Store store) {
    return new Guest(0, store.delivery(money.currentValue()));
  }

  public List<Lotto> hasAllLotto() {
    emptySizeIsValid(allLotteryTickets.size());
    return allLotteryTickets;
  }

  private void emptySizeIsValid(int size) {
    if (size <= 0) {
      throw new LottoSizeException();
    }
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
    return Objects.equals(money, guest.money) && Objects.equals(allLotteryTickets,
        guest.allLotteryTickets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(money, allLotteryTickets);
  }
}
