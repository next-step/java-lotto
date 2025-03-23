package calculator;

import calculator.domain.NumbersAndOperatorsGroup;
import calculator.domain.Operator;

import java.util.List;

public class Calculator {
  public static int calculate(String input) {
    validate(input);
    NumbersAndOperatorsGroup numbersAndOperatorsGroup = TokenParser.parse(input);
    return calculate(numbersAndOperatorsGroup.getNumbers(), numbersAndOperatorsGroup.getOperators());
  }

  private static void validate(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값이 null입니다.");
    }
    if (input.isEmpty()) {
      throw new IllegalArgumentException("입력값이 빈 문자열입니다.");
    }
  }

  private static int calculate(List<Integer> numbers, List<Operator> operators) {
    int result = numbers.get(0);
    for (int i = 0; i < operators.size(); i++) {
      Operator op = operators.get(i);
      result = op.apply(result, numbers.get(i + 1));
    }
    return result;
  }
}
