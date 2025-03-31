package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {

  private static final String DELIMITER = " ";

  private final List<Token> tokens;

  public Formula(String formula) {
    if (formula.trim().isEmpty()) {
      throw new IllegalArgumentException("식은 빈 값일 수 없습니다.");
    }
    this.tokens = Arrays.stream(formula.split(DELIMITER))
        .map(Token::from)
        .collect(Collectors.toList());
    validate();
  }

  private void validate() {
    validateCharacters();
    validateNumberPosition();
  }

  private void validateNumberPosition() {
    if (!(tokens.get(0).isNumeric() && tokens.get(tokens.size() - 1).isNumeric())) {
      throw new IllegalArgumentException("식의 처음과 마지막은 숫자여야 합니다.");
    }
  }

  private void validateCharacters() {
    if (hasInvalidCharacter()) {
      throw new IllegalArgumentException("숫자와 사칙연산 기호만 입력할 수 있습니다.");
    }
  }

  private boolean hasInvalidCharacter() {
    return tokens.stream()
        .anyMatch(Token::isNotValid);
  }

  public int calculateBy(Calculator calculator) {
    return calculator.calculate(tokens);
  }
}
