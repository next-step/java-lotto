package lotto.domain;

import lotto.dto.RankingPrizedCount;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotalRankings {

  private static final long WINNING_FAILED_COUNT = 0L;

  private final Map<LottoRanking, Long> winningCountsGroupByLottoRanking;

  public TotalRankings(List<LottoRanking> rankings) {
    this.winningCountsGroupByLottoRanking = toMap(rankings);
  }

  private Map<LottoRanking, Long> toMap(List<LottoRanking> rankings) {
    return rankings.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<RankingPrizedCount> createPrizeInfos() {
    return Arrays.stream(LottoRanking.values())
            .filter(this::isPrized)
            .sorted(Comparator.comparingInt(this::getRankingMatchCount))
            .map(lottoRanking -> new RankingPrizedCount(lottoRanking, winningCountsGroupByLottoRanking.getOrDefault(lottoRanking, WINNING_FAILED_COUNT)))
            .collect(Collectors.toList());
  }

  private boolean isPrized(LottoRanking lottoRanking) {
    return lottoRanking != LottoRanking.NONE;
  }

  private int getRankingMatchCount(LottoRanking lottoRanking) {
    return lottoRanking.getMatchCount();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TotalRankings that = (TotalRankings) o;
    return winningCountsGroupByLottoRanking.equals(that.winningCountsGroupByLottoRanking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(winningCountsGroupByLottoRanking);
  }
}
