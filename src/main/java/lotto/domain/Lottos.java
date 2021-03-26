package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

  public static final Money PRICE = new Money(Lotto.PRICE);

  private final List<Lotto> lottos;

  public Lottos(Money money) {
    long size = money.divideBy(PRICE).toInteger();

    lottos = new ArrayList<>((int) size);
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

  public List<Integer> compare(final Lotto winningLotto) {
    List<Integer> list = new ArrayList<>();

    for (Lotto lotto : lottos) {
      list.add(lotto.compare(winningLotto));
    }
    return list;
  }
}
