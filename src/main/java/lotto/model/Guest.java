package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Guest {

  private final Money money;
  private final List<Product> allLottoList;

  public Guest(int money) {
    this(money, null);
  }

  public Guest(int money, List<Product> allLottoList) {
    this.money = new Money(money);
    this.allLottoList = allLottoList;
  }

  public boolean visit(Store store) {
    return store.prepareProduct();
  }

  public List<Product> choiceProduct(Store store) {
    return store.delivery(Integer.parseInt(money.toString()));
  }
}
