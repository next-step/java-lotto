package lotto.domain;

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
    //todo: isBonusBallConditionMatched 의 parameter로 result를 넣어주는게 좋을까 result.isBonusBallMatched() 넣어주는게 좋을까
    return result.isMatchCountOf(this.matchCount)
            && this.bonusBallCondition.isBonusBallConditionMatched(result.isBonusBallMatched());
  }

  protected int matchCount() {
    return this.matchCount.value();
  }

  protected boolean bonusBallCondition() {
    return this.bonusBallCondition.needMatch();
  }

  @Override
  public String toString() {
    return "Condition{" +
            "matchCount='" + this.matchCount + '\'' +
            ", bonusBallCondition='" + this.bonusBallCondition + '\'' +
            "}";
  }
}
