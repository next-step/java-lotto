package calculator;

import calculator.domain.NumbersAndOperatorsGroup;
import calculator.domain.Operator;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {
  private static final String DELIMITER = " ";

  public static NumbersAndOperatorsGroup parse(String input) {
    String[] tokens = input.split(DELIMITER);
    List<Operator> operators = extractOperators(tokens);
    List<Integer> numbers = extractNumbers(tokens);
    return new NumbersAndOperatorsGroup(numbers, operators);
  }

  private static List<Integer> extractNumbers(String[] tokens) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < tokens.length; i += 2) {
      numbers.add(Integer.parseInt(tokens[i]));
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
