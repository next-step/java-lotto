package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {

  private final Map<LottoPrize, Integer> statistics = new TreeMap<>();
  private final double rateOfReturn;

  public WinningStatistics(List<Lotto> lottos, Lotto winningLotto) {
    for (Lotto lotto : lottos) {
      int matchedCnt = lotto.getMatchingNumberCnt(winningLotto);
      LottoPrize lottoPrize = LottoPrize.of(matchedCnt);

      if (statistics.containsKey(lottoPrize)) {
        statistics.put(lottoPrize, statistics.get(lottoPrize) + 1);
      } else {
        statistics.put(lottoPrize, 1);
      }
    }

    long inputMoney = lottos.size() * LottoGame.LOTTO_PRICE.getValue();
    long totalPrizeMoney = 0;
    for (LottoPrize key : statistics.keySet()) {
      totalPrizeMoney += key.getPrizeMoney() * statistics.get(key);
    }
    this.rateOfReturn = ((double) totalPrizeMoney / inputMoney);
  }

  public int getResultByMatchedCnt(int matchecCnt) {
    LottoPrize lottoPrize = LottoPrize.of(matchecCnt);
    return statistics.getOrDefault(lottoPrize, 0);
  }

  public double getRateOfReturn() {
    return rateOfReturn;
  }
}
