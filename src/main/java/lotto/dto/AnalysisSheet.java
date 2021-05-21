package lotto.dto;

import lotto.domain.TotalRankings;
import lotto.ui.GainLossDiscriminator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnalysisSheet {

  public static final String YIELD_ANALYSIS_FORMAT = "총 수익률은 %.2f입니다. (%s)";

  private final List<PrizeInfo> prizeInfos;

  private final double yield;

  public AnalysisSheet(TotalRankings totalRankings, long purchasingAmount) {
    List<PrizeInfo> prizes = totalRankings.createPrizeInfos();
    this.prizeInfos = prizes;
    this.yield = calculateYield(prizes, purchasingAmount);
  }

  public String toStringPrizeInfos() {
    return prizeInfos.stream()
            .map(PrizeInfo::toString)
            .collect(Collectors.joining(System.lineSeparator()));
  }

  public String toStringYieldAnalysis() {
    return String.format(YIELD_ANALYSIS_FORMAT, yield, GainLossDiscriminator.of(yield).getMessage());
  }

  private double calculateYield(List<PrizeInfo> prizeInfos, long purchasingAmount) {
    return calculateTotalAmounts(prizeInfos) / (double) purchasingAmount;
  }

  private long calculateTotalAmounts(List<PrizeInfo> prizeInfos) {
    return prizeInfos.stream()
        .map(prizeInfo -> prizeInfo.getWinningAmount() * prizeInfo.getWinningCount())
        .reduce(0L, Long::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnalysisSheet that = (AnalysisSheet) o;
    return Double.compare(that.yield, yield) == 0 && prizeInfos.equals(that.prizeInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizeInfos, yield);
  }
}
