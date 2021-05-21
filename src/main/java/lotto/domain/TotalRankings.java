package lotto.domain;

import lotto.dto.PrizeInfo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotalRankings {

  private final Map<LottoRanking, Long> winningCountsGroupByLottoRanking;

  public TotalRankings(List<LottoRanking> rankings) {
    this.winningCountsGroupByLottoRanking = toMap(rankings);
  }

  private Map<LottoRanking, Long> toMap(List<LottoRanking> rankings) {
    return rankings.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<PrizeInfo> createPrizeInfos() {
    return winningCountsGroupByLottoRanking.entrySet()
        .stream()
        .filter(entry -> isPrized(entry.getKey()))
        .sorted(Comparator.comparingInt(entry -> rankingMatchCount(entry.getKey())))
        .map(entry -> new PrizeInfo(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }

  private boolean isPrized(LottoRanking lottoRanking) {
    return lottoRanking != LottoRanking.NONE;
  }

  private int rankingMatchCount(LottoRanking lottoRanking) {
    return lottoRanking.matchCount();
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
