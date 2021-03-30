package lotto.domain;

import java.util.Arrays;

public enum Ranking {
  FIRST(6, 2000000000),
  SECOND_BONUS(5,30000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  DROP(0, 0);

  private Integer count;
  private Integer prize;

  Ranking(Integer count, Integer prize) {
    this.count = count;
    this.prize = prize;
  }

  public Integer getCount() {
    return count;
  }

  public Integer getPrize() {
    return prize;
  }

  public static Ranking ofCount(int count) {
    return Arrays.stream(values())
        .filter(value -> value.getCount().equals(count))
        .findFirst()
        .orElse(Ranking.DROP);
  }

}
