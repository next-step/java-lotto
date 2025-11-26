package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

  private final Map<Integer, Integer> matchCounts;
  private final double profitRate;

  public LottoResult(List<Lotto> lottos, Lotto winningNumbers, PurchaseAmount amount) {
    this.matchCounts = calculateResult(lottos, winningNumbers);
    this.profitRate = calculateProfitRate(calculateTotalPrize(matchCounts), amount);
  }

  public Map<Integer, Integer> matchCounts() {
    return matchCounts;
  }

  public double profitRate() {
    return profitRate;
  }

  private static Map<Integer, Integer> calculateResult(List<Lotto> lottos, Lotto winningNumbers) {
    Map<Integer, Integer> result = new HashMap<>();
    for (Lotto lotto : lottos) {
      int match = countMatches(lotto, winningNumbers);
      result.put(match, result.getOrDefault(match, 0) + 1);
    }
    return result;
  }

  private static long calculateTotalPrize(Map<Integer, Integer> result) {
    long totalPrize = 0;
    for (LottoRank rank : LottoRank.values()) {
      int count = result.getOrDefault(rank.matchCount(), 0);
      totalPrize += (long) count * rank.prize();
    }
    return totalPrize;
  }

  private static double calculateProfitRate(long totalPrize, PurchaseAmount amount) {
    return (double) totalPrize / amount.value();
  }

  private static int countMatches(Lotto lotto, Lotto winningNumbers) {
    return lotto.countMatchingNumbers(winningNumbers);
  }

}
