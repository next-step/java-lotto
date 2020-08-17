package step2;

public class LottosAnalysis {

  private final Winning winning;
  private final Lottos lottos;

  public LottosAnalysis(Winning winning, Lottos lottos) {
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
