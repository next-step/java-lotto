package calculator.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

  private static final int ZERO_CONDITION = 0;
  private static final int ODD_CONDITION = 1;
  private static final int EVEN_CONDITION = 2;
  private static final String ILLEGAL_OPERATOR_MESSAGE = "올바른 사칙 연산을 입력해주세요.";
  private static final String INCALCULABLE_MESSAGE = "계산이 가능한 수식을 입력해주세요.";
  private static final Pattern OPERATORS_SYMBOL = Pattern.compile("^(\\+|-|\\*|\\/)$");
  private final Operators operators;
  private final Operands operands;

  public Calculator(List<String> operators, List<String> operands) {
    validateOperation(operators, operands);

    this.operators = Operators.of(operators);
    this.operands = Operands.of(operands);
  }

  public static Calculator createCalculator(List<String> operations) {
    List<String> operators = validateOperators(splitOperations(operations, ODD_CONDITION));
    List<String> operands = splitOperations(operations, ZERO_CONDITION);

    return new Calculator(operators, operands);
  }

  private static List<String> splitOperations(List<String> operations, int condition) {
    return IntStream.range(0, operations.size())
            .filter(idx -> idx % EVEN_CONDITION == condition)
            .mapToObj(operations::get)
            .collect(Collectors.toList());
  }

  private static List<String> validateOperators(List<String> operators) {
    return operators.stream()
            .map(Calculator::validateOperator)
            .collect(Collectors.toList());
  }

  private static String validateOperator(String operator) {
    if (!matchOperator(operator)) {
      throw new IllegalArgumentException(ILLEGAL_OPERATOR_MESSAGE);
    }

    return operator;
  }

  private static boolean matchOperator(String operator) {
    Matcher operatorMatcher = OPERATORS_SYMBOL.matcher(operator);

    return operatorMatcher.find();
  }

  public int calculate() {
    return operands.operands().stream()
            .map(Operand::operand)
            .reduce((total, cur) -> operators.next().applyCalculation(total, cur))
            .get();
  }

  private void validateOperation(List<String> operators, List<String> operands) {
    if (incalculable(operators, operands) || hasOnlyOperands(operators, operands)) {
      throw new IllegalArgumentException(INCALCULABLE_MESSAGE);
    }
  }

  private boolean incalculable(List<String> operators, List<String> operands) {
    return operands.size() - operators.size() != 1;
  }

  private boolean hasOnlyOperands(List<String> operators, List<String> operands) {
    return operators.size() == 0 && operands.size() == 1;
  }
}
