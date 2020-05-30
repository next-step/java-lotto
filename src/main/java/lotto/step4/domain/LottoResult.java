package lotto.step4.domain;

public class LottoResult {
  private final Prizes prizes;
  private final Lottos lottos;

  private LottoResult(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.prizes = lottos.matches(winningLotto);
  }

  public static LottoResult of (Lottos lottos, WinningLotto winningLotto) {
    return new LottoResult(lottos, winningLotto);
  }

  public Prizes getPrizes() {
    return prizes;
  }

  public long getPayoff () {
    return prizes.stream()
                 .mapToLong(Prize::getTotalPrize)
                 .sum();
  }

  public double resultLottoGamePayOffRatio () {
    return (double)getPayoff() / lottos.getPrice();
  }
}
