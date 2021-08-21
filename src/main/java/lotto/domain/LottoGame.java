package lotto.domain;

import java.util.List;

public class LottoGame {

  private static final int LOTTO_PRICE = 1000;
  private final List<Lotto> lottos;

  public LottoGame(int money) {
    checkMoney(money);
    lottos = LottoGenerator.generate(money / LOTTO_PRICE);
  }

  public List<Lotto> getLotto() {
    return lottos;
  }

  private void checkMoney(int money) {
    if (money < LOTTO_PRICE) {
      throw new IllegalArgumentException("최소 구매 금액은 " + LOTTO_PRICE + "원 입니다.");
    }
  }
}
