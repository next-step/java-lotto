package lotto.domain;

import java.util.Map;
import java.util.Objects;

public final class MatchNumberCount {

  private final Map<Integer, Integer> matchNumberCount;

  public MatchNumberCount(Map<Integer, Integer> matchNumberCount) {
    this.matchNumberCount = matchNumberCount;
  }

  public Integer getRevenue() {
    return matchNumberCount.get(3) * 5000
        + matchNumberCount.get(4) * 50000
        + matchNumberCount.get(5) * 1500000
        + matchNumberCount.get(6) * 2000000000;
  }

  public void print() {
    System.out.println("3개 일치 (5000원)- " + matchNumberCount.get(3) + "개");
    System.out.println("4개 일치 (50000원)- " + matchNumberCount.get(4) + "개");
    System.out.println("5개 일치 (1500000)- " + matchNumberCount.get(5) + "개");
    System.out.println("6개 일치 (2000000000원)- " + matchNumberCount.get(6) + "개");
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
