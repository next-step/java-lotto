package calculator;

import calculator.domain.OperandAndOperatorGroup;
import calculator.domain.Operand;
import calculator.domain.Operator;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {
  private static final String DELIMITER = " ";

  public static OperandAndOperatorGroup parse(String input) {
    String[] tokens = input.split(DELIMITER);
    List<Operator> operators = extractOperators(tokens);
    List<Operand> operands = extractOperands(tokens);
    return new OperandAndOperatorGroup(operands, operators);
  }

  private static List<Operand> extractOperands(String[] tokens) {
    List<Operand> numbers = new ArrayList<>();
    for (int i = 0; i < tokens.length; i += 2) {
      numbers.add(Operand.fromString(tokens[i]));
    }
    return numbers;
  }

  private static List<Operator> extractOperators(String[] tokens) {
    List<Operator> operators = new ArrayList<>();
    for (int i = 1; i < tokens.length; i += 2) {
      operators.add(Operator.from(tokens[i]));
    }
    return operators;
  }
}
