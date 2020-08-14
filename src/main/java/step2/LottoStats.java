package step2;

import static step2.LottoGenerator.ONE_PRICE;

import java.util.List;

public class LottoStats {

  private final List<LottoStat> lottoStats;

  public LottoStats(List<LottoStat> lottoStats) {
    this.lottoStats = lottoStats;
  }

  public double rate(int payment) {
    int amount = (payment / ONE_PRICE) * ONE_PRICE;
    double total = lottoStats.stream()
        .mapToDouble(LottoStat::total)
        .sum();

    return Math.floor((total / amount)  * 100)  / 100.0;
  }

}

