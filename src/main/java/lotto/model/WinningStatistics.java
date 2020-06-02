package lotto.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatistics {

  private Map<PrizeTier, Integer> prizeTierCntMap;
  private int income = 0;
  private int expense = 0;

  private WinningStatistics(Lotto lotto, WinningNumbers winningNumbers) {
    prizeTierCntMap = new HashMap<>();

    for (PrizeTier prizeTier : PrizeTier.values()) {
      prizeTierCntMap.put(prizeTier, 0);
    }

    prizeTierCntMap = sortPrizeTierIntegerMap(prizeTierCntMap);

    for (LottoNumbers numbers : lotto.getLottoList()) {
      prizeTierCntMap
          .computeIfPresent(winningNumbers.getPrizeTier(numbers), (key, value) -> ++value);
    }

    for (PrizeTier prizeTier : prizeTierCntMap.keySet()) {
      int lottoCnt = prizeTierCntMap.get(prizeTier);
      income += prizeTier.getPrize() * lottoCnt;
      expense += Price.LOTTO.getPrice() * lottoCnt;
    }
  }

  public static WinningStatistics newInstanceFromLottoAndWinningNumbers(Lotto lotto,
      WinningNumbers winningNumbers) {
    return new WinningStatistics(lotto, winningNumbers);
  }

  private static Map<PrizeTier, Integer> sortPrizeTierIntegerMap(
      Map<PrizeTier, Integer> prizeTierCntMap) {
    return prizeTierCntMap.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> e.getKey().getMatchCnt())
        ).collect(Collectors
            .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new)
        );
  }

  public Map<PrizeTier, Integer> getPrizeTierCntMap() {
    return prizeTierCntMap;
  }

  public double getPrifitRate() {
    return ProfitRateCalculator.calculateByTwoDecimalPlaces(income, expense);
  }
}
