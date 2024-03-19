package domain;

import java.util.Objects;

public class Result {
  private static final PositiveNumber WIN_MIN = new PositiveNumber(3);
  private final PositiveNumber matchCount;

  public Result(PositiveNumber matchCount) {
    this.matchCount = matchCount;
  }

  public static Result of(PositiveNumber matchCount) {
    return new Result(matchCount);
  }

  public boolean win() {
    return this.matchCount.greaterOrEqual(WIN_MIN);
  }

  public PositiveNumber matchCount() {
    return this.matchCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Result result = (Result) o;
    return matchCount.equals(result.matchCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchCount);
  }

  @Override
  public String toString() {
    return String.format("Result[matchCount: %d]", this.matchCount.value());
  }
}
