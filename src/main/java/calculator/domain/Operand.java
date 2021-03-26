package calculator.domain;

import java.util.Objects;

public class Operand {
  private static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";
  private final int operand;

  public Operand(String formula) {
    this.operand = parseInt(formula);
    validation(this.operand);
  }

  private void validation(int operand) {
    if(isNegativeNumber(operand)) {
      throw new IllegalArgumentException("음수는 입력하실 수 없습니다.");
    }
  }

  private int parseInt(String formula) {
    if(isNullOrEmptyString(formula)) {
      return 0;
    }
    return formulaToInt(formula);
  }

  private int formulaToInt(String formula) {
    if(isNumeric(formula)) {
      return Integer.parseInt(formula);
    }
    throw new IllegalArgumentException("잘못 된 값이 입력되었습니다.");
  }

  private boolean isNullOrEmptyString(String formula) {
    return formula == null || formula.equals("");
  }

  private boolean isNumeric(String formula) {
    return formula.matches(NUMERIC_REGEX);
  }

  private boolean isNegativeNumber(int operand) {
    return operand < 0;
  }

  public int getOperand() {
    return operand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Operand)) {
      return false;
    }
    Operand operand1 = (Operand) o;
    return getOperand() == operand1.getOperand();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOperand());
  }
}
