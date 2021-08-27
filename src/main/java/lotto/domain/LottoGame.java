package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

  private final List<Lotto> lottos = new ArrayList<>();

  public LottoGame(long money) {
    this(new Money(money));
  }

  public LottoGame(Money money) {
    checkMoney(money);
    long cnt = money.value() / Lotto.PRICE.value();
    for (long i = 0; i < cnt; i++) {
      this.lottos.add(Lotto.issueByAuto());
    }
  }

  public List<Lotto> lottos() {
    return this.lottos;
  }

  public WinningResult winningResult(Lotto winningLotto) {
    return new WinningResult(this.lottos, winningLotto);
  }

  private void checkMoney(Money money) {
    if (money.compareTo(Lotto.PRICE) < 0) {
      throw new IllegalArgumentException("최소 구매 금액은 " + Lotto.PRICE.value() + "원 입니다.");
    }
  }
}
