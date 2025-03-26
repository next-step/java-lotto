import java.util.Arrays;

public class Formula {

  private static final String[] OPERATORS = {"*", "/", "+", "-"};
  private static final String DELIMITER = " ";

  private final String[] tokens;

  public Formula(String formula) {
    if (formula.trim().isEmpty()) {
      throw new IllegalArgumentException("식은 빈 값일 수 없습니다.");
    }
    this.tokens = formula.split(DELIMITER);
    validate();
  }

  private void validate() {
    validateCharacters();
    validateNumberPosition();
  }

  private void validateNumberPosition() {
    if (!(isNumeric(tokens[tokens.length - 1]) && isNumeric(tokens[0]))) {
      throw new IllegalArgumentException("식의 처음과 마지막은 숫자여야 합니다.");
    }
  }

  private void validateCharacters() {
    if (hasInvalidCharacter()) {
      throw new IllegalArgumentException("숫자와 사칙연산 기호만 입력할 수 있습니다.");
    }
  }

  private boolean hasInvalidCharacter() {
    return Arrays.stream(tokens)
        .anyMatch(token -> !isAllowedToken(token));
  }

  private boolean isAllowedToken(String token) {
    return isNumeric(token) || isOperator(token);
  }

  private boolean isOperator(String token) {
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

  public String[] getTokens() {
    return tokens.clone();
  }
}
