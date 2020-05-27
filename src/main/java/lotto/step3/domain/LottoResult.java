package lotto.step3.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoResult {
  private final List<Prize> prizes;
  private final WinningLotto winningLotto;
  private final Lottos lottos;

  private LottoResult(Lottos lottos, WinningLotto winningLotto) {
    this.winningLotto = winningLotto;
    this.lottos = lottos;
    this.prizes = Rank.stream()
                      .map(rank -> Prize.of(rank, getWinningCount(rank)))
                      .collect(toList());
  }

  public static LottoResult of (Lottos lottos, WinningLotto winningLotto) {
    return new LottoResult(lottos, winningLotto);
  }

  private long getWinningCount (Rank rank) {
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

  public double resultLottoGamePayOffRatio () {
    return (double)getPayoff() / lottos.getPrice();
  }
}
