package calculator.domain;

import util.StringUtils;

public class CalculatorValue {

  private final int value;
  private final String stringifiedValue;

  public CalculatorValue(String stringifiedValue) {
    this.value = extractValueIfValid(stringifiedValue);
    this.stringifiedValue = stringifiedValue;
  }

  public CalculatorValue(int value) {
    this.value = value;
    this.stringifiedValue = String.valueOf(value);
  }

  private int extractValueIfValid(String originalValue) {
    if (!StringUtils.isDigit(originalValue)) {
      throw new IllegalArgumentException();
    }
    return Integer.parseInt(originalValue);
  }

  public int getValue() {
    return value;
  }

  public String getStringifiedValue() {
    return stringifiedValue;
  }
}
