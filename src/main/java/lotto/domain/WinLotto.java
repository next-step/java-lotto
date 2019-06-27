package lotto.domain;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WinLotto {

  private Map<Rank, Long> winLotto;

  public WinLotto getWinLotto(List<Rank> ranks) {
    this.winLotto = ranks.stream()
        .collect(groupingBy(
            identity(),
            counting()));
    return this;
  }

  public double profitRate(int price) {
      return winLotto.entrySet()
        .stream()
        .mapToLong(WinLotto::applyAsLong)
        .sum() / price;
  }

  public long getOrDefault(Rank rank, long defaultValue) {
    return winLotto.getOrDefault(rank, defaultValue);
  }

  private static long applyAsLong(Map.Entry<Rank, Long> rank) {
    return rank.getKey().getMoney(rank.getValue());
  }
}
