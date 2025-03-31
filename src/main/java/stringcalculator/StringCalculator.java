package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

  private static final String DELIMITER = " ";

  public int calculateString(String input) {
    List<String> tokens = parseValidTokens(input);
    return calculate(tokens);
  }

  private int calculate(List<String> tokens) {
    int result = Integer.parseInt(tokens.get(0));
    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).equals("+")) {
        result += Integer.parseInt(tokens.get(i + 1));
      }
    }

    return result;
  }

  private static List<String> parseValidTokens(String input) {

    List<String> tokens = Arrays.asList(input.split(DELIMITER));
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException();
    }

    return tokens;
  }
}
