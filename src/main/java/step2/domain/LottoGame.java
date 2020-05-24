package step2.domain;

public class LottoGame {

  private final Lotto winningLotto;
  private final LottoShop lottoShop;

  public LottoGame(LottoShop lottoShop, Lotto winningLotto) {
    this.lottoShop = lottoShop;
    this.winningLotto = winningLotto;
  }

  public long getWinningCount (Rank rank) {
    return lottoShop.stream()
                    .filter(lotto -> getEqualRankOfLotto(lotto, rank))
                    .count();
  }

  public double getPayoffRatio () {
    long payoff = Rank.stream()
                      .map(rank -> rank.getPrice() * getWinningCount(rank))
                      .reduce(0L, Math::addExact);
    return (double)payoff / lottoShop.getPrice();
  }

  public static LottoGame of (LottoShop lottoShop, Lotto winningLotto) {
    return new LottoGame(lottoShop, winningLotto);
  }

  public boolean getEqualRankOfLotto (Lotto lotto, Rank rank) {
    long same = lotto.stream()
                     .filter(winningLotto::has)
                     .count();
    return Rank.valueOf(same).equals(rank);
  }
}
