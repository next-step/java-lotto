package lotto.domain;

public class ConditionDto {
  private int matchCount;
  private boolean bonusBallCondition;

  public ConditionDto(final Condition condition) {
    this.matchCount = condition.matchCount();
    this.bonusBallCondition = condition.bonusBallCondition();
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public boolean getBonusBallCondition() {
    return this.bonusBallCondition;
  }
}
