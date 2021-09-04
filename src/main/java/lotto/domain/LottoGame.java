package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.InvalidLottoPurchasePriceException;

public class LottoGame {

  private final List<Lotto> lottos = new ArrayList<>();

  public LottoGame(long money) {
    this(new Money(money));
  }

  public LottoGame(Money money) {
    validateMoney(money);
    long cnt = money.value() / Lotto.PRICE.value();
    for (long i = 0; i < cnt; i++) {
      lottos.add(Lotto.issueByAuto());
    }
  }

  public List<Lotto> lottos() {
    return lottos;
  }

  public WinningResult winningResult(WinningInfo winningInfo) {
    return new WinningResult(lottos, winningInfo);
  }

  private void validateMoney(Money money) {
    if (money.compareTo(Lotto.PRICE) < 0) {
      throw new InvalidLottoPurchasePriceException();
    }
  }
}
