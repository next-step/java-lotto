package calculator;

import calculator.domain.Operand;
import calculator.domain.OperandAndOperatorGroup;
import calculator.domain.Operator;

import java.util.List;

public class Calculator {
  public static int calculate(String input) {
    validate(input);
    OperandAndOperatorGroup operandAndOperatorGroup = TokenParser.parse(input);
    return calculate(operandAndOperatorGroup.getOperands(), operandAndOperatorGroup.getOperators());
  }

  private static void validate(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값이 null입니다.");
    }
    if (input.isEmpty()) {
      throw new IllegalArgumentException("입력값이 빈 문자열입니다.");
    }
  }

  private static int calculate(List<Operand> operands, List<Operator> operators) {
    Operand result = operands.get(0);
    for (int i = 0; i < operators.size(); i++) {
      Operator op = operators.get(i);
      result = op.apply(result, operands.get(i + 1));
    }
    return result.toInt();
  }
}
