package domain;

import java.util.Objects;

public class Result {
  private final PositiveNumber matchCount;
  private final Boolean bonusBallMatched;

  public static Result of(int matchCount, Boolean bonusBallMatched) {
    return new Result(PositiveNumber.of(matchCount), bonusBallMatched);
  }

  public static Result of(PositiveNumber matchCount, Boolean bonusBallMatched) {
    return new Result(matchCount, bonusBallMatched);
  }

  public Result(PositiveNumber matchCount, Boolean bonusBallMatched) {
    this.matchCount = matchCount;
    this.bonusBallMatched = bonusBallMatched;
  }

  public PositiveNumber matchCount() {
    return this.matchCount;
  }

  public Boolean bonusBallMatched() {
    return this.bonusBallMatched;
  }

  public Prize prize() {
    return Prize.from(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Result result = (Result) o;
    return matchCount.equals(result.matchCount) && bonusBallMatched.equals(result.bonusBallMatched);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchCount, bonusBallMatched);
  }

  @Override
  public String toString() {
    return String.format("Result[matchCount: %d, bonusBallMatched:%s]", this.matchCount.value(), this.bonusBallMatched);
  }
}
