package calculator.domain;

import java.util.List;

public class Calculator {

  private final Tokenizer tokenizer;

  public Calculator() {
    this.tokenizer = new Tokenizer();
  }

  public Calculator(String regex) {
    this.tokenizer = new Tokenizer(regex);
  }

  public int calculate(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("입력값이 null이거나 빈 공백입니다.");
    }

    List<String> tokens = tokenizer.split(input);
    Expression expression = new Expression(tokens);
    return expression.calculate();
  }
}
