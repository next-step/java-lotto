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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.matchCount.value());
    sb.append("개 일치");
    if (this.bonusBallCondition.equals(BonusBallCondition.TRUE)) {
      sb.append(", 보너스 볼 일치");
    }

    return sb.toString();
  }
}
