package lotto.domain.prize;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoReward {
  private final Map<LottoPrize, Integer> prizeMap;

  public LottoReward(Lottos lottos, WinningLotto winningLotto) {
    this.prizeMap = createPrizeMap(lottos, winningLotto);
  }

  private Map<LottoPrize, Integer> createPrizeMap(Lottos lottoList, WinningLotto winningLotto) {
    Map<LottoPrize, Integer> prizeMap = Arrays.stream(LottoPrize.values())
            .collect(Collectors.toMap(prize -> prize, prize -> 0));

    List<Integer> matchingNumberCounts = lottoList.countMatchingNumbers(winningLotto);
    List<Boolean> matchingBonusCounts = lottoList.countMatchingBonus(winningLotto);

    updatePrizeMap(matchingNumberCounts, matchingBonusCounts, prizeMap);
    return prizeMap;
  }

  private static void updatePrizeMap(List<Integer> matchingNumberCounts, List<Boolean> matchingBonusCounts, Map<LottoPrize, Integer> prizeMap) {
    for (int i = 0; i < matchingNumberCounts.size(); i++) {
      int matchCount = matchingNumberCounts.get(i);
      boolean isBonus = matchingBonusCounts.get(i);
      updatePrizeCount(prizeMap, matchCount, isBonus);
    }
  }

  private static void updatePrizeCount(Map<LottoPrize, Integer> prizeMap, int matchCount, boolean isBonus) {
    Optional<LottoPrize> prize = LottoPrizeMatcher.findPrize(matchCount, isBonus);
    prize.ifPresent(value -> prizeMap.put(value, prizeMap.get(value) + 1));
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
