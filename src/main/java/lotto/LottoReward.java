package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoReward {
  private final Map<LottoPrize, Integer> prizeMap;

  public LottoReward(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
    this.prizeMap = createPrizeMap(lottos, winningLotto, bonusNumber);
  }

  private Map<LottoPrize, Integer> createPrizeMap(Lottos lottoList, Lotto winningLotto, LottoNumber bonusNumber) {
    Map<LottoPrize, Integer> prizeMap = Arrays.stream(LottoPrize.values())
            .collect(Collectors.toMap(prize -> prize, prize -> 0));

    List<Integer> matchingNumberCounts = lottoList.countMatchingNumbers(winningLotto);
    List<Boolean> matchingBonusCounts = lottoList.countMatchingBonus(bonusNumber);

    for (int i = 0; i < matchingNumberCounts.size(); i++) {
      int matchCount = matchingNumberCounts.get(i);
      boolean isBonus = matchingBonusCounts.get(i);
      if (!LottoPrize.contains(matchCount, isBonus)) continue;

      LottoPrize prize = LottoPrize.getPrizeFromMatchCount(matchCount, isBonus);
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
