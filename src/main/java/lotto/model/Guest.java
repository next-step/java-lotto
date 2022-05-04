package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.exception.LottoSizeException;

public final class Guest {

  private final Money money;
  private final List<Lotto> holdingLotteryTickets;

  public Guest(long money) {
    this(money, null);
  }

  public Guest(long money, List<Lotto> holdingLotteryTickets) {
    this.money = new Money(money);
    this.holdingLotteryTickets = holdingLotteryTickets;
  }

  public Guest choiceProduct(Store store) {
    return new Guest(0, store.delivery(money.currentValue()));
  }

  public List<Lotto> hasAllLotto() {
    emptySizeIsValid(holdingLotteryTickets.size());
    return holdingLotteryTickets;
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
    return Objects.equals(money, guest.money) && Objects.equals(holdingLotteryTickets,
        guest.holdingLotteryTickets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(money, holdingLotteryTickets);
  }
}
