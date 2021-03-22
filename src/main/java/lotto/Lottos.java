package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

  public static final Money PRICE = new Money(1000);

  private final List<Object> lottos;

  public Lottos(Money money) {
    int size = money.divideBy(PRICE).toInteger();

    lottos = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      lottos.add(new Object());
    }
  }

  public int count() {
    return lottos.size();
  }
}
