package stringcalculator;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import stringcalculator.exception.IllegalOperatorException;

public enum Operator {

  SUM("+", (operand1, operand2) -> operand1 + operand2),
  MINUS("-", (operand1, operand2) -> operand1 - operand2),
  MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
  DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

  private final String operator;
  private final BinaryOperator<Integer> expression;

  Operator(String operator, BinaryOperator<Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  static Operator findOperator(String value) {
    return Stream.of(values())
        .filter(operator -> operator.operator.equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalOperatorException(value));
  }

  int calc(int operand1, int operand2) {
    return expression.apply(operand1, operand2);
  }
}
