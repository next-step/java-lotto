package lotto.model;

import java.util.Objects;
import lotto.enums.Release;

public final class Statistics {

  private final Release release;

  public Statistics(Release release) {
    this.release = release;
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
    return release == that.release;
  }

  @Override
  public int hashCode() {
    return Objects.hash(release);
  }
}