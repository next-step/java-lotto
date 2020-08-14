package step2;

import java.util.List;

public class LottoAnalysis {

  private final Winning winning;
  private final List<Lotto> lottos;

  public LottoAnalysis(Winning winning, List<Lotto> lottos) {
    this.winning = winning;
    this.lottos = lottos;
  }

  public LottoStats analyze() {
    LottoStats lottoStats = new LottoStats();
    for (Lotto lotto : lottos) {
      lottoStats.decide(winning.sameNumberCount(lotto));
    }

    return lottoStats;
  }
}
