package lotto.step2.domain;

public class LottoGame {

  private final Lotto winningLotto;
  private final Lottos lottos;

  public LottoGame(Lottos lottos, Lotto winningLotto) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
  }

  public static LottoGame of (Lottos lottos, Lotto winningLotto) {
    return new LottoGame(lottos, winningLotto);
  }

  public long getWinningCount (Rank rank) {
    return lottos.stream()
                 .filter(lotto -> getRankOfLotto(lotto).equals(rank))
                 .count();
  }

  public double getPayoffRatio () {
    long payoff = Rank.stream()
                      .map(rank -> rank.getPrice() * getWinningCount(rank))
                      .reduce(0L, Math::addExact);
    return (double)payoff / lottos.getPrice();
  }

  public Rank getRankOfLotto (Lotto lotto) {
    long same = winningLotto.sameCount(lotto);
    return Rank.valueOf(same);
  }
}
