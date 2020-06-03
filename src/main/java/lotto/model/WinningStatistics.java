package lotto.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatistics {

  private Map<PrizeTier, Integer> prizeTierCntMap;
  private Money income;
  private Money expense;

  private WinningStatistics(Lottos lottos, WinningLotto winningLotto) {
    prizeTierCntMap = new HashMap<>();
    income = new Money(0);
    expense = new Money(0);

    for (PrizeTier prizeTier : PrizeTier.values()) {
      prizeTierCntMap.put(prizeTier, 0);
    }

    prizeTierCntMap = sortPrizeTierIntegerMap(prizeTierCntMap);

    countPrizeTier(lottos, winningLotto);

    setIncomeAndExpense();
  }

  private Map<PrizeTier, Integer> sortPrizeTierIntegerMap(
      Map<PrizeTier, Integer> prizeTierCntMap) {
    return prizeTierCntMap.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> e.getKey().getMatchCnt())
        ).collect(Collectors
            .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new)
        );
  }

  private void countPrizeTier(Lottos lottos, WinningLotto winningLotto) {
    for (Lotto lotto : lottos.getLottoList()) {
      prizeTierCntMap
          .computeIfPresent(winningLotto.getPrizeTier(lotto), (key, value) -> ++value);
    }
  }

  private void setIncomeAndExpense() {
    for (PrizeTier prizeTier : prizeTierCntMap.keySet()) {
      int lottoCnt = prizeTierCntMap.get(prizeTier);
      income.add(new Money(prizeTier.getPrize() * lottoCnt));
      expense.add(new Money(Lotto.PRICE.getValue() * lottoCnt));
    }
  }

  public static WinningStatistics newInstanceFromLottoAndWinningNumbers(Lottos lottos,
      WinningLotto winningLotto) {
    return new WinningStatistics(lottos, winningLotto);
  }

  public Map<PrizeTier, Integer> getPrizeTierCntMap() {
    return prizeTierCntMap;
  }

  public double getProfitRate() {
    return ProfitRateCalculator.calculateByTwoDecimalPlaces(income, expense);
  }
}
