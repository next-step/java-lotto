package lotto.model;

import java.util.Objects;
import lotto.enums.Rank;

public final class Statistics {

  private final Rank rank;

  public Statistics(Rank rank) {
    this.rank = rank;
  }

  public double yield(int winningAmount, int haveMoney) {
    return Math.floor((double) winningAmount / haveMoney * 100) / 100.0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics that = (Statistics) o;
    return rank == that.rank;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank);
  }
}
