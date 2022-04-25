package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Guest {

  private final Money money;
  private final Store store;

  public Guest(int money) {
    this(money, null);
  }

  public Guest(int money, Store store) {
    this.money = new Money(money);
    this.store = store;
  }

  public int boughtLottoCount() {
    Store lotto = store.getProductsCount(Integer.parseInt(money.toString()));
    return Integer.parseInt(lotto.toString());
  }

  public List<Product> haveLottoList() {
    List<Product> lottoList = new ArrayList<>();
    int productCount = boughtLottoCount();
    while (productCount-- != 0) {
      lottoList.add(store.deliverLotto());
    }

    return lottoList;
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
