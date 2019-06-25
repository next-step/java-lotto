package lotto.util;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {

  public static Map<Rank, Long> statistics(List<Rank> ranks) {
    return ranks.stream()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()));
  }

  public static double profitRate(int price, Map<Rank, Long> ranks) {
    return ranks.entrySet()
        .stream()
        .mapToLong(rank -> rank.getKey().getWinningMoney() * rank.getValue())
        .sum() / price;
  }
}
