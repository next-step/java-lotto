package lotto.domain;

import java.util.List;

public class LottoGame {

  public static final Money LOTTO_PRICE = new Money(1000);
  private final List<Lotto> lottos;

  public LottoGame(long money) {
    this(new Money(money));
  }

  public LottoGame(Money money) {
    checkMoney(money);
    lottos = LottoGenerator.generateByRandomNumber((money.getValue() / LOTTO_PRICE.getValue()));
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public WinningResult getWinningStatics(Lotto winningLotto) {
    return new WinningResult(lottos, winningLotto);
  }

  private void checkMoney(Money money) {
    if (money.compareTo(LOTTO_PRICE) < 0) {
      throw new IllegalArgumentException("최소 구매 금액은 " + LOTTO_PRICE + "원 입니다.");
    }
  }
}
