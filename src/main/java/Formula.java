import java.util.Arrays;
import java.util.List;

public class Formula {

  private static final String[] OPERATORS = {"*", "/", "+", "-"};
  private static final String DELIMITER = " ";

  private final String[] tokens;

  public Formula(String formula) {
    if (formula.trim().isEmpty()) {
      throw new IllegalArgumentException("식은 빈 값일 수 없습니다.");
    }
    this.tokens = formula.split(DELIMITER);
    validateFormula(tokens);
  }

  private void validateFormula(String[] formula) {
    validateCharacters(formula);
    validateNumberPosition(formula);
  }

  private void validateNumberPosition(String[] formula) {
    if (!(isNumeric(formula[formula.length - 1]) && isNumeric(formula[0]))) {
      throw new IllegalArgumentException("식의 처음과 마지막은 숫자여야 합니다.");
    }
  }

  private void validateCharacters(String[] formula) {
    List<String> tokens = Arrays.asList(formula);
    if (hasInvalidCharacter(tokens)) {
      throw new IllegalArgumentException("숫자와 사칙연산 기호만 입력할 수 있습니다.");
    }
  }

  private boolean hasInvalidCharacter(List<String> tokens) {
    return tokens.stream()
        .anyMatch(token -> !isAllowedToken(token));
  }

  private boolean isAllowedToken(String token) {
    return isNumeric(token) || isArithmeticOperator(token);
  }

  private boolean isArithmeticOperator(String token) {
    return Arrays.asList(OPERATORS).contains(token);
  }

  private boolean isNumeric(String token) {
    try {
      Integer.parseInt(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public int calculate() {
    int result = Integer.parseInt(tokens[0]);
    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      int operand = Integer.parseInt(tokens[i + 1]);
      result = calculate(result, operator, operand);
    }
    return result;
  }

  private int calculate(int left, String operator, int right) {
    switch (operator) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
      default:
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
  }
}
