package lotto.domain;

import lotto.enums.Rank;

import java.util.Map;
import java.util.Objects;

import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static lotto.enums.Rank.FOURTH;
import static lotto.enums.Rank.SECOND;
import static lotto.enums.Rank.THIRD;

public final class MatchNumberCount {

  private final Map<Rank, Integer> matchNumberCount;

  public MatchNumberCount(Map<Rank, Integer> matchNumberCount) {
    this.matchNumberCount = matchNumberCount;
  }

  public Integer getRevenue() {
    int revenue = 0;

    for (Rank rank : Rank.values()) {
      revenue += matchNumberCount.get(rank) * rank.getWinningMoney();
    }

    return revenue;
  }

  public void print() {
    System.out.println("3개 일치 (5000원)- " + matchNumberCount.get(FIFTH) + "개");
    System.out.println("4개 일치 (50000원)- " + matchNumberCount.get(FOURTH) + "개");
    System.out.println("5개 일치 (1500000)- " + matchNumberCount.get(THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + matchNumberCount.get(SECOND) + "개");
    System.out.println("6개 일치 (2000000000원)- " + matchNumberCount.get(FIRST) + "개");
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
