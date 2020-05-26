package step3.domain;

public class LottoGame {

  private final Lottos lottos;
  private final Prizes prizes;

  public LottoGame(Lottos lottos, Prizes prizes) {
    this.lottos = lottos;
    this.prizes = prizes;
  }

  public static LottoGame of (Lottos lottos, Prizes prizes) {
    return new LottoGame(lottos, prizes);
  }

  public double getPayoffRatio () {
    long payoff = prizes.getPayoff();
    return (double)payoff / lottos.getPrice();
  }

}
