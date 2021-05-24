package lotto.domain;

import lotto.enums.Rank;

import java.util.Map;
import java.util.Objects;

public final class MatchNumberCount {

  private final Map<Rank, Long> matchNumberCount;

  public MatchNumberCount(Map<Rank, Long> matchNumberCount) {
    this.matchNumberCount = matchNumberCount;
  }

  public Long getRevenue() {
    return matchNumberCount.keySet().stream()
        .map(rank -> matchNumberCount.get(rank) * rank.getWinningMoney())
        .reduce(0L, Long::sum);
  }

  public Map<Rank, Long> getMatchNumberCount() {
    return matchNumberCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchNumberCount that = (MatchNumberCount) o;
    return Objects.equals(matchNumberCount, that.matchNumberCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchNumberCount);
  }
}
