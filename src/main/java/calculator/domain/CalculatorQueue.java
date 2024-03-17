package calculator.domain;

import java.util.*;

public class CalculatorQueue {

  public static final String CALCULATOR_INPUT_INCORRECT = "문자열 계산기 입력 값이 올바르지 않습니다. 다시 확인해주세요. input: %s";
  public static final String INPUT_ORDER_INCORRECT = "연산이 불가능한 구조의 입력 값 입니다. 다시 확인해주세요. input: %s";
  public static final String CALCULATOR_INPUT_ERROR = "문자열 계산기 입력 값에 이슈가 있습니다. input: %s, exception: %s";

  public static final List<String> OPERATORS = List.of("+", "-", "/", "*");

  private final Queue<Integer> numbers;
  private final Queue<String> operators;

  private CalculatorQueue(List<Integer> numbers, List<String> operators) {
    this.numbers = new LinkedList<>(numbers);
    this.operators = new LinkedList<>(operators);
  }

  public static CalculatorQueue of(String input) {

    List<Integer> numbers = new ArrayList<>();
    List<String> operators = new ArrayList<>();

    validateIsEmptyOrNull(input);
    validateInputOrder(input, numbers, operators);

    return new CalculatorQueue(numbers, operators);
  }

  public Queue<Integer> getNumbers() {
    return numbers;
  }

  public Queue<String> getOperators() {
    return operators;
  }

  private static void validateIsEmptyOrNull(String input) {
    if (Objects.isNull(input) || input.isBlank()) {
      throw new IllegalArgumentException(String.format(CALCULATOR_INPUT_INCORRECT, input));
    }
  }

  private static void validateInputOrder(String input, List<Integer> numbers, List<String> operators) {
    boolean numberOderFlag = true;
    String[] inputValues = input.split(" ");

    for (String value : inputValues) {
      validateIsCalculatePossible(input, numberOderFlag, value, numbers, operators);
      numberOderFlag = !numberOderFlag;
    }
  }

  private static void validateIsCalculatePossible(String input, boolean numberOderFlag, String value, List<Integer> numbers, List<String> operators) {
    if (numberOderFlag) {
      isNumber(input, value, numbers);
      return;
    }
    isOperator(input, value, operators);
  }

  private static void isNumber(String input, String value, List<Integer> numbers) {
    try {
      numbers.add(Integer.parseInt(value));
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException(String.format(INPUT_ORDER_INCORRECT, input));
    } catch (Exception e) {
      throw new RuntimeException(String.format(CALCULATOR_INPUT_ERROR, input, e.getMessage()), e);
    }
  }

  private static void isOperator(String input, String value, List<String> operators) {
    if (!OPERATORS.contains(value)) {
      throw new IllegalArgumentException(String.format(INPUT_ORDER_INCORRECT, input));
    }

    try {
      operators.add(value);
    } catch (Exception e) {
      throw new RuntimeException(String.format(CALCULATOR_INPUT_ERROR, input, e.getMessage()), e);
    }
  }
}
