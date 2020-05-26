package step3.domain;

public class LottoGame {

  private final double payoffRatio;

  public LottoGame(double payoffRatio) {
    this.payoffRatio = payoffRatio;
  }

  public static LottoGame of (long purchaseAmount, Prizes prizes) {
    long payoff = prizes.getPayoff();
    double payoffRatio = (double)payoff / purchaseAmount;
    return new LottoGame(payoffRatio);
  }

  public static LottoGame of (Lottos lottos, WinningLotto winningLotto) {
    long payoff = Prizes.of(lottos, winningLotto).getPayoff();
    double payoffRatio = (double)payoff / lottos.getPrice();
    return new LottoGame(payoffRatio);
  }

  public double getPayoffRatio () {
    return payoffRatio;
  }

}
