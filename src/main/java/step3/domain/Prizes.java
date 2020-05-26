package step3.domain;

import java.util.List;

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

  private long getWinningCount (Lottos lottos, Rank rank) {
    return lottos.stream()
                 .map(winningLotto::getRankOfLotto)
                 .filter(rank::equals)
                 .count();
  }

  public long getPayoff () {
    return this.prizes.stream()
                      .mapToLong(Prize::getTotalPrize)
                      .sum();
  }
}
