package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoChecker {

  private static final Map<Integer, Integer> PRIZES = Map.of(
      3, 5000,
      4, 50000,
      5, 1500000,
      6, 2000000000
  );

  public static Map<Integer, Long> calculateResults(List<Lotto> tickets,
      WinningLotto winningLotto) {
    return tickets.stream()
        .map(lotto -> winningLotto.matchingWinningNumber(lotto))
        .filter(PRIZES::containsKey)
        .collect(Collectors.groupingBy(matchCount -> matchCount, Collectors.counting()));
  }

  public static double calculateProfitRate(Map<Integer, Long> results, int purchaseAmount) {
    long totalWinning = results.entrySet().stream()
        .mapToLong(entry -> PRIZES.get(entry.getKey()) * entry.getValue())
        .sum();

    return (double) totalWinning / purchaseAmount;
  }
}
