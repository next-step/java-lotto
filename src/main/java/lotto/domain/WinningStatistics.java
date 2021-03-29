package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class WinningStatistics {

  private final Map<Rank, Long> winningStatistics;

  private WinningStatistics(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
    List<Match> matches = lottos.compare(winningLotto, bonusNumber);
    winningStatistics = matches.stream()
        .map(Rank::from)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public WinningStatistics(Lottos lottos, LastWinningNumber lastWinningNumber) {
    this(lottos, lastWinningNumber.getLastWinningLotto(), lastWinningNumber.getBonusNumber());
  }

  public long countOf(Rank rank) {
    return winningStatistics.getOrDefault(rank, 0L);
  }

  public Money totalMoney() {
    Money total = new Money(0);
    for (Entry<Rank, Long> entry : winningStatistics.entrySet()) {
      Rank rank = entry.getKey();
      Money rankTotal = rank.getMoney().multiply(entry.getValue());
      total = total.sum(rankTotal);
    }
    return total;
  }
}
