package domain;

public class Condition {
  private final PositiveNumber matchCount;
  private final BonusBallCondition bonusBallCondition;

  public Condition(int matchCount, BonusBallCondition bonusBallCondition) {
    this(PositiveNumber.of(matchCount), bonusBallCondition);
  }

  public Condition(PositiveNumber matchCount, BonusBallCondition bonusBallCondition) {
    this.matchCount = matchCount;
    this.bonusBallCondition = bonusBallCondition;
  }

  public Boolean accept(Result result) {
    if (!this.matchCount.equals(result.matchCount())) {
      return false;
    }

    if (this.bonusBallCondition.equals(BonusBallCondition.DONT_CARE)) {
      return true;
    }

    return this.bonusBallCondition.equals(BonusBallCondition.TRUE) == result.bonusBallMatched();
  }

  public PositiveNumber matchCount() {
    return this.matchCount;
  }

  public BonusBallCondition bonusBallCondition() {
    return this.bonusBallCondition;
  }

  @Override
  public String toString() {
    return "Condition{" +
            "matchCount=" + this.matchCount + '\'' +
            ", bonusBallCondition=" + this.bonusBallCondition + '\'' +
            "}";
  }
}
