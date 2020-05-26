package step3.domain;

public class LottoGame {

  private final Lotto winningLotto;
  private final Lottos lottos;
  private final LottoNumber bonusNumber;

  public LottoGame(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
    this.bonusNumber = bonusNumber;
  }

  public static LottoGame of (Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
    return new LottoGame(lottos, winningLotto, bonusNumber);
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
    boolean matchBonus = lotto.has(bonusNumber);
    return Rank.valueOf(same, matchBonus);
  }
}
