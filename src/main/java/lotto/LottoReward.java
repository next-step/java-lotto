package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoReward {
  private final Map<LottoPrize, Integer> prizeMap;

  public LottoReward(Lottos lottos, Lotto winningLotto) {
    this.prizeMap = createPrizeMap(lottos, winningLotto);
  }

  private Map<LottoPrize, Integer> createPrizeMap(Lottos lottoList, Lotto winningLotto) {
    Map<LottoPrize, Integer> prizeMap = Arrays.stream(LottoPrize.values())
            .collect(Collectors.toMap(prize -> prize, prize -> 0));

    List<Integer> matchingNumberCounts = lottoList.countMatchingNumbers(winningLotto);
    List<Integer> filteredMatchingNumberCounts = matchingNumberCounts.stream().filter(
            count -> LottoPrize.getAllMatchCounts().contains(count)).collect(Collectors.toList());
    for (Integer count: filteredMatchingNumberCounts) {
      LottoPrize prize = LottoPrize.getPrizeFromMatchCount(count);
      prizeMap.put(prize, prizeMap.get(prize) + 1);
    }
    return prizeMap;
  }

  public int getPrizeCount(LottoPrize prize) {
    return prizeMap.get(prize);
  }

  public int calculateTotalWinningMoney() {
    return prizeMap.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
            .sum();
  }
}
