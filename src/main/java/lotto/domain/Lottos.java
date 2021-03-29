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

  public List<Lotto> getLottos() {
    return lottos;
  }

  public List<Match> compare(final Lotto winningLotto, LottoNumber bonusNumber) {
    List<Match> list = new ArrayList<>();

    for (Lotto lotto : lottos) {
      list.add(lotto.compare(winningLotto, bonusNumber));
    }
    return list;
  }
}
