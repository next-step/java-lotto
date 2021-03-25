package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

  public static final Money PRICE = new Money(Lotto.PRICE);

  private final List<Lotto> lottos;

  public Lottos(Money money) {
    int size = money.divideBy(PRICE).toInteger();

    lottos = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      lottos.add(new Lotto());
    }
  }

  public Lottos(List<Lotto> lottoList) {
    this.lottos = lottoList;
  }

  public int count() {
    return lottos.size();
  }

  public void print() {
    for (Lotto lotto : lottos) {
      lotto.printLottoNumbers();
    }
  }

  public List<Integer> compare(Lotto winningLotto) {
    return null;
  }
}
