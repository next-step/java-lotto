package lotto;

import java.util.List;

public class Statistics {

  private Lottos purchasedLottos;
  private Lotto lastWeekWinLotto;

  public Statistics(Lottos lottos, Lotto lastWeekWinLotto) {
    this.purchasedLottos = lottos;
    this.lastWeekWinLotto = lastWeekWinLotto;
  }

  public int getSameNumberCount(int sameCount) {
    List<Lotto> purchasedLotto = purchasedLottos.getPurchasedLotto();
    return (int) purchasedLotto.stream().map(lotto -> lotto.countSameNumber(lastWeekWinLotto))
        .filter(value -> value==sameCount)
        .count();
  }

}
