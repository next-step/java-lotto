package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatics {

  private final Map<LottoPrize, Integer> statics = new TreeMap<>();
  private final double rateOfReturn;

  public WinningStatics(List<Lotto> lottos, Lotto winningLotto) {
    for (Lotto lotto : lottos) {
      int matchedCnt = lotto.getMatchingNumberCnt(winningLotto);
      LottoPrize lottoPrize = LottoPrize.of(matchedCnt);

      if (statics.containsKey(lottoPrize)) {
        statics.put(lottoPrize, statics.get(lottoPrize) + 1);
      } else {
        statics.put(lottoPrize, 1);
      }
    }

    int inputMoney = lottos.size() * LottoGame.LOTTO_PRICE;
    int totalPrizeMoney = 0;
    for (LottoPrize key : statics.keySet()) {
      totalPrizeMoney += key.getPrizeMoney() * statics.get(key);
    }
    this.rateOfReturn = ((double) totalPrizeMoney / inputMoney);
  }

  public int getResultByMatchedCnt(int matchecCnt) {
    LottoPrize lottoPrize = LottoPrize.of(matchecCnt);
    return statics.getOrDefault(lottoPrize, 0);
  }

  public double getRateOfReturn() {
    return rateOfReturn;
  }
}
