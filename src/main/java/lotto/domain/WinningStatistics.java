package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class WinningStatistics {

  private final Map<Rank, Long> winningStatistics;

  public WinningStatistics(Lottos lottos, Lotto winningLotto) {
    List<Integer> matchCounts = lottos.compare(winningLotto);
    winningStatistics = matchCounts.stream()
        .map(Rank::of)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public long countOf(Rank rank) {
    return winningStatistics.getOrDefault(rank, 0L);
  }

  public Money totalMoney() {
    return null;
  }
}
