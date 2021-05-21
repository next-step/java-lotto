package lotto.domain;

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
