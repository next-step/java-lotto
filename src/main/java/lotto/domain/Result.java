package lotto.domain;

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

  private Result(PositiveNumber matchCount, Boolean bonusBallMatched) {
    this.matchCount = matchCount;
    this.bonusBallMatched = bonusBallMatched;
  }

  public Boolean isMatchCountOf(PositiveNumber matchCount) {
    return this.matchCount.equals(matchCount);
  }

  public Boolean isBonusBallMatched() {
    return this.bonusBallMatched;
  }

  public Boolean isNotBonusBallMatched() {
    return !this.bonusBallMatched;
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
    return "Result{" +
            "matchCount='" + this.matchCount + '\'' +
            ", bonusBallMatched='" + this.bonusBallMatched + '\'' +
            "}";
  }
}
