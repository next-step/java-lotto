package calculator;

import java.util.ArrayList;
import java.util.List;

public class TokenParser {

  public static NumbersAndOperatorsGroup parse(String[] tokens) {
    List<Integer> numbers = extractNumbers(tokens);
    List<String> operators = extractOperators(tokens);
    return new NumbersAndOperatorsGroup(numbers, operators);
  }

  private static List<Integer> extractNumbers(String[] tokens) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < tokens.length; i += 2) {
      numbers.add(Integer.parseInt(tokens[i]));
    }
    return numbers;
  }

  private static List<String> extractOperators(String[] tokens) {
    List<String> operators = new ArrayList<>();
    for (int i = 1; i < tokens.length; i += 2) {
      operators.add(tokens[i]);
    }
    return operators;
  }
}
