package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Money;

public final class Lottos {

  public static final Money PRICE = new Money(Lotto.PRICE);

  private final List<Lotto> lottos;

  public Lottos() {
    this(new ArrayList<>());
  }

  public Lottos(LottoCount lottoCount) {
    this(lottoCount.toInteger());
  }

  public Lottos(long size) {
    this(new ArrayList<>((int) size));
  }

  public Lottos(List<Lotto> lottoList) {
    this.lottos = lottoList;
  }

  public int count() {
    return lottos.size();
  }

  public List<Lotto> getLottos() {
    return Collections.unmodifiableList(lottos);
  }

  public List<LottoMatch> compare(WinningLotto winningLotto) {
    List<LottoMatch> list = new ArrayList<>();

    for (Lotto lotto : lottos) {
      list.add(winningLotto.compareLotto(lotto));
    }
    return list;
  }

  public void addLotto(Lotto lotto) {
    this.lottos.add(lotto);
  }

  public void addLottoList(List<Lotto> lottoList) {
    lottoList.forEach(this::addLotto);
  }
}
