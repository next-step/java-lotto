package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Expression {

  private List<Number> numbers;
  private List<Operator> operators;

  public Expression(List<String> tokens) {
    validateTokens(tokens);
    this.numbers = parseNumbers(tokens);
    this.operators = parseOperators(tokens);
  }

  public Expression(List<Number> numbers, List<Operator> operators) {
    this.numbers = numbers;
    this.operators = operators;
  }

  private void validateTokens(List<String> tokens) {
    if (tokens == null || tokens.isEmpty()) {
      throw new IllegalArgumentException("입력값이 null이거나 빈 공백입니다.");
    }
    if (tokens.size() % 2 == 0) {
      throw new IllegalArgumentException("올바르지 않은 형식입니다.");
    }
  }

  private List<Number> parseNumbers(List<String> tokens) {
    List<Number> numbers = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i += 2) {
      numbers.add(new Number(tokens.get(i)));
    }
    return numbers;
  }

  private List<Operator> parseOperators(List<String> tokens) {
    List<Operator> operators = new ArrayList<>();
    for (int i = 1; i < tokens.size(); i += 2) {
      operators.add(Operator.from(tokens.get(i)));
    }
    return operators;
  }

  public int calculate() {
    Number result = numbers.getFirst();
    for (int i = 0; i < operators.size(); i++) {
      result = result.apply(operators.get(i), numbers.get(i + 1));
    }
    return result.getValue();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < operators.size(); i++) {
      sb.append(operators.get(i)).append(" ").append(numbers.get(i + 1));
    }
    return sb.toString();
  }
}
