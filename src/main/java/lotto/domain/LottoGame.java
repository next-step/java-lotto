package lotto.domain;

import java.util.List;

public class LottoGame {

  private final List<Lotto> lottos;

  public LottoGame(long money) {
    this(new Money(money));
  }

  public LottoGame(Money money) {
    checkMoney(money);
    lottos = LottoGenerator.generateByRandomNumber((money.getValue() / Lotto.PRICE.getValue()));
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public WinningResult getWinningResult(Lotto winningLotto) {
    return new WinningResult(lottos, winningLotto);
  }

  private void checkMoney(Money money) {
    if (money.compareTo(Lotto.PRICE) < 0) {
      throw new IllegalArgumentException("최소 구매 금액은 " + Lotto.PRICE.getValue() + "원 입니다.");
    }
  }
}
