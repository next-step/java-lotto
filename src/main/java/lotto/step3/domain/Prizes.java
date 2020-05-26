package lotto.step3.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Prizes {
  private final List<Prize> prizes;
  private final WinningLotto winningLotto;

  private Prizes (Lottos lottos, WinningLotto winningLotto) {
    this.winningLotto = winningLotto;
    this.prizes = Rank.stream()
                      .map(rank -> Prize.of(rank, getWinningCount(lottos, rank)))
                      .collect(toList());
  }

  public static Prizes of (Lottos lottos, WinningLotto winningLotto) {
    return new Prizes(lottos, winningLotto);
  }

  private long getWinningCount (Lottos lottos, Rank rank) {
    return lottos.stream()
                 .map(winningLotto::getRankOfLotto)
                 .filter(rank::equals)
                 .count();
  }

  public Stream<Prize> stream() {
    return prizes.stream();
  }

  public long getPayoff () {
    return stream().mapToLong(Prize::getTotalPrize).sum();
  }
}
