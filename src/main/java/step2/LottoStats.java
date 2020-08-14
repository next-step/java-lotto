package step2;

import java.util.List;

public class LottoStats {

  private final List<LottoStat> lottoStats;

  public LottoStats(List<LottoStat> lottoStats) {
    this.lottoStats = lottoStats;
  }

  public double rate(int payment) {
    double total = lottoStats.stream()
        .mapToDouble(LottoStat::total)
        .sum();

    return Math.floor((total / payment)  * 100)  / 100.0;
  }

}

