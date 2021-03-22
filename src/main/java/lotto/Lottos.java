package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

  public static final int PRICE = 1000;

  private final List<Object> lottos;

  public Lottos(int money) {
    lottos = new ArrayList<>();
    for (int i = 0; i < money / PRICE; i++) {
      lottos.add(new Object());
    }
  }

  public int count() {
    return lottos.size();
  }
}
