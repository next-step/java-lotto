package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {

  private final Map<LottoPrize, Integer> statistics = new TreeMap<>();

  public WinningStatistics(List<Lotto> lottos, Lotto winningLotto) {
    for (Lotto lotto : lottos) {
      LottoPrize lottoPrize = LottoPrize.of(lotto.matchedNumberCnt(winningLotto));
      putInStatistics(lottoPrize);
    }
  }

  public long totalPrizeMoney() {
    return Arrays.stream(LottoPrize.values())
        .mapToLong(prize -> prize.prizeMoney() * cntByLottoPrize(prize)).sum();
  }

  public int cntByLottoPrize(LottoPrize lottoPrize) {
    return this.statistics.getOrDefault(lottoPrize, 0);
  }

  private void putInStatistics(LottoPrize lottoPrize) {
    if (this.statistics.containsKey(lottoPrize)) {
      this.statistics.put(lottoPrize, this.statistics.get(lottoPrize) + 1);
      return;
    }
    this.statistics.put(lottoPrize, 1);
  }
}
