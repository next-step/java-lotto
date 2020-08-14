package step2;

import java.util.List;

public class LottoStats {

  private final List<LottoStat> lottoStats;

  public LottoStats(List<LottoStat> lottoStats) {
    this.lottoStats = lottoStats;
  }

  public double rate(int payment) {
    int total = 0;
    for (LottoStat lottoStat : lottoStats) {
      total += lottoStat.total();
    }

    return total / payment;
  }

}

