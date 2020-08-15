package step2;

import static step2.LottoGenerator.ONE_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoStats {

  private final List<LottoStat> lottoStats;

  public LottoStats() {
    this(
        Arrays.asList(
            new LottoStat(LottoRank.First),
            new LottoStat(LottoRank.Second),
            new LottoStat(LottoRank.Third),
            new LottoStat(LottoRank.Fourth),
            new LottoStat(LottoRank.Fifth)));
  }

  public LottoStats(int first, int second, int third, int fourth, int fifth) {
    this(
        Arrays.asList(
            new LottoStat(LottoRank.First, first),
            new LottoStat(LottoRank.Second, second),
            new LottoStat(LottoRank.Third, third),
            new LottoStat(LottoRank.Fourth, fourth),
            new LottoStat(LottoRank.Fifth, fifth)));
  }

  private LottoStats(List<LottoStat> lottoStats) {
    this.lottoStats = lottoStats;
  }

  public double rate(int payment) {
    int amount = (payment / ONE_PRICE) * ONE_PRICE;
    double total = lottoStats.stream().mapToDouble(LottoStat::total).sum();

    return Math.floor((total / amount) * 100) / 100.0;
  }

  public void decide(int matchCount, boolean hasBonusNumber) {
    for (LottoStat lottoStat : lottoStats) {
      lottoStat.decide(matchCount, hasBonusNumber);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoStats that = (LottoStats) o;
    return Objects.equals(lottoStats, that.lottoStats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoStats);
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (LottoStat lottoStat : lottoStats) {
      sb.append(lottoStat + "\n");
    }

    return sb.toString();
  }
}
