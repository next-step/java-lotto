package stringcalculator;

import stringcalculator.exception.IllegalNumberException;

public class Operand {

  private static final String NUMBER_RANGE_REGEX = "^-?\\d+$";

  private int value;

  public Operand(String value) {
    this.value = convertToInt(value);
  }

  private int convertToInt(String value) {
    validateOperand(value);
    return Integer.parseInt(value);
  }

  private void validateOperand(String value) {
    if (!value.matches(NUMBER_RANGE_REGEX)) {
      throw new IllegalNumberException(value);
    }
  }

  public void applyCalculationResult(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
