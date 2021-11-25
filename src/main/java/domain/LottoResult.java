package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

  private static final int INCREMENTAL_STEP = 1;

  private final Map<LottoPrize, Integer> result;

  public LottoResult(Lottos lottos, Lotto target) {
    this.result = makeResult(lottos.getLottos(), target);
  }

  private Map<LottoPrize, Integer> makeResult(List<Lotto> lottos, Lotto winningLotto) {
    Map<LottoPrize, Integer> result = new HashMap<>();
    for (Lotto lotto : lottos) {
      LottoPrize lottoPrize = LottoPrize.find(matchedNumberCount(lotto, winningLotto));
      result.put(lottoPrize, increasePrizeCount(result, lottoPrize));
    }

    return result;
  }

  private long matchedNumberCount(Lotto lotto, Lotto winningLotto) {
    return lotto.getLottoNumbers().stream()
            .filter(winningLotto.getLottoNumbers()::contains)
            .count();
  }

  private int increasePrizeCount(Map<LottoPrize, Integer> result, LottoPrize lottoPrize) {
    if (result.containsKey(lottoPrize)) {
      return result.get(lottoPrize) + INCREMENTAL_STEP;
    }
    return INCREMENTAL_STEP;
  }

  public int result(LottoPrize LottoPrize) {
    if (this.result.containsKey(LottoPrize)) {
      return this.result.get(LottoPrize);
    }
    return 0;
  }

  public double totalLottoPrize() {
    return this.result.keySet().stream()
            .mapToDouble(LottoPrize -> LottoPrize.getPrize() * this.result.get(LottoPrize))
            .sum();
  }

}
