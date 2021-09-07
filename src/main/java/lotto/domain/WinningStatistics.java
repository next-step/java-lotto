package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {

  private final Map<LottoPrize, Integer> statistics = new TreeMap<>();

  public WinningStatistics(List<Lotto> lottos, WinningInfo winningInfo) {
    for (Lotto lotto : lottos) {
      int matchNumberCnt = lotto.matchNumberCnt(winningInfo.winningLottoNumbers());
      boolean matchBonus = lotto.contains(winningInfo.bonusLottoNumber());
      LottoPrize lottoPrize = LottoPrize.of(matchNumberCnt, matchBonus);
      putInStatistics(lottoPrize);
    }
  }

  public long totalPrizeMoney() {
    return Arrays.stream(LottoPrize.values())
        .mapToLong(prize -> prize.prizeMoney() * cntByLottoPrize(prize))
        .sum();
  }

  public int cntByLottoPrize(LottoPrize lottoPrize) {
    return statistics.getOrDefault(lottoPrize, 0);
  }

  private void putInStatistics(LottoPrize lottoPrize) {
    if (statistics.containsKey(lottoPrize)) {
      statistics.put(lottoPrize, statistics.get(lottoPrize) + 1);
      return;
    }
    statistics.put(lottoPrize, 1);
  }
}
