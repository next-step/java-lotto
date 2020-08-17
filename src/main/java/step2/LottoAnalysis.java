package step2;

public class LottoAnalysis {

  private final Winning winning;
  private final Lottos lottos;

  public LottoAnalysis(Winning winning, Lottos lottos) {
    this.winning = winning;
    this.lottos = lottos;
  }

  public LottoStats analyze() {
    LottoStats lottoStats = new LottoStats();
    for (Lotto lotto : lottos) {
      lottoStats.decide(winning.matchCount(lotto), winning.hasBonusNumber(lotto));
    }

    return lottoStats;
  }
}
