package lotto.enums;

public enum ChoiceType {
  GUESSED(1), WRONG(0);

  private final int increaseValue;

  ChoiceType(int increaseValue) {
    this.increaseValue = increaseValue;
  }

  public int getIncreaseValue() {
    return increaseValue;
  }
}
