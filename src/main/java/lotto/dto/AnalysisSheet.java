package lotto.dto;

import lotto.domain.TotalRankings;
import lotto.ui.GainLossDiscriminator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnalysisSheet {

  public static final String YIELD_ANALYSIS_FORMAT = "총 수익률은 %.2f입니다. (%s)";

  private final List<RankingPrizedCount> rankingPrizedCounts;

  private final double yield;

  public AnalysisSheet(TotalRankings totalRankings, long purchasingAmount) {
    List<RankingPrizedCount> prizes = totalRankings.createPrizeInfos();
    this.rankingPrizedCounts = prizes;
    this.yield = calculateYield(prizes, purchasingAmount);
  }

  public String toStringPrizeInfos() {
    return rankingPrizedCounts.stream()
            .map(RankingPrizedCount::toString)
            .collect(Collectors.joining(System.lineSeparator()));
  }

  public String toStringYieldAnalysis() {
    return String.format(YIELD_ANALYSIS_FORMAT, yield, GainLossDiscriminator.of(yield).getMessage());
  }

  private double calculateYield(List<RankingPrizedCount> rankingPrizedCounts, long purchasingAmount) {
    return calculateTotalAmounts(rankingPrizedCounts) / (double) purchasingAmount;
  }

  private long calculateTotalAmounts(List<RankingPrizedCount> rankingPrizedCounts) {
    return rankingPrizedCounts.stream()
        .map(rankingPrizedCount -> rankingPrizedCount.getWinningAmount() * rankingPrizedCount.getWinningCount())
        .reduce(0L, Long::sum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnalysisSheet that = (AnalysisSheet) o;
    return Double.compare(that.yield, yield) == 0 && rankingPrizedCounts.equals(that.rankingPrizedCounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rankingPrizedCounts, yield);
  }
}
