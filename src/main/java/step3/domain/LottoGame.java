package step3.domain;

public class LottoGame {

  private final WinningLotto winningLotto;
  private final Lottos lottos;

  public LottoGame(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
  }

  public static LottoGame of (Lottos lottos, WinningLotto winningLotto) {
    return new LottoGame(lottos, winningLotto);
  }

  public long getWinningCount (Rank rank) {
    return lottos.stream()
                 .map(winningLotto::getRankOfLotto)
                 .filter(rank::equals)
                 .count();
  }

  public double getPayoffRatio () {
    long payoff = Rank.stream()
                      .map(rank -> rank.getPrice() * getWinningCount(rank))
                      .reduce(0L, Math::addExact);
    return (double)payoff / lottos.getPrice();
  }
}
