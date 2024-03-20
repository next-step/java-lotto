package calculator.domain;

import java.util.Objects;

import static calculator.domain.CalculatorQueue.CALCULATOR_INPUT_ERROR;

public class Operand {

  public static final String ENTERED_NON_NUMERIC_VALUE = "숫자가 아닌 값이 들어왔습니다. 다시 확인해주세요. value: %s, input: %s";
  private final int operand;

  public Operand(int operand) {
    this.operand = operand;
  }

  public static Operand of(String value, String input) {
    return new Operand(toInt(value, input));
  }

  private static int toInt(String value, String input) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException(String.format(ENTERED_NON_NUMERIC_VALUE, value, input));
    } catch (Exception e) {
      throw new RuntimeException(String.format(CALCULATOR_INPUT_ERROR, input, e.getMessage()), e);
    }
  }

  public int toNumber() {
    return this.operand;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Operand operand1 = (Operand) o;
    return operand == operand1.operand;
  }

  @Override
  public int hashCode() {
    return Objects.hash(operand);
  }
}
