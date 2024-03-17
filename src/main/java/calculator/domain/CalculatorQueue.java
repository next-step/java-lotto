package calculator.domain;

import java.util.*;

public class CalculatorQueue {

  public static final String CALCULATOR_INPUT_INCORRECT = "문자열 계산기 입력 값이 올바르지 않습니다. 다시 확인해주세요. input: %s";
  public static final String CALCULATOR_INPUT_ERROR = "문자열 계산기 입력 값에 이슈가 있습니다. input: %s, exception: %s";

  private final Queue<Operand> operands;
  private final Queue<Operator> operators;

  private CalculatorQueue(List<Operand> operands, List<Operator> operators) {
    this.operands = new LinkedList<>(operands);
    this.operators = new LinkedList<>(operators);
  }

  public static CalculatorQueue of(String input) {

    List<Operand> numbers = new ArrayList<>();
    List<Operator> operators = new ArrayList<>();

    validateIsEmptyOrNull(input);
    validateInputOrder(input, numbers, operators);

    return new CalculatorQueue(numbers, operators);
  }

  public Queue<Operand> getOperands() {
    return operands;
  }

  public Queue<Operator> getOperators() {
    return operators;
  }

  private static void validateIsEmptyOrNull(String input) {
    if (Objects.isNull(input) || input.isBlank()) {
      throw new IllegalArgumentException(String.format(CALCULATOR_INPUT_INCORRECT, input));
    }
  }

  private static void validateInputOrder(String input, List<Operand> operands, List<Operator> operators) {
    boolean numberOderFlag = true;
    String[] inputValues = input.split(" ");

    for (String value : inputValues) {
      validateIsCalculatePossible(input, numberOderFlag, value, operands, operators);
      numberOderFlag = !numberOderFlag;
    }
  }

  private static void validateIsCalculatePossible(String input, boolean numberOderFlag, String value, List<Operand> operands, List<Operator> operators) {
    if (numberOderFlag) {
      operands.add(new Operand(Operand.isOperand(value, input)));
      return;
    }

    if (Operator.isOperator(value)) {
      operators.add(new Operator(value));
    }
  }
}
