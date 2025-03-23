package calculator.domain;

import java.util.List;

public class NumbersAndOperatorsGroup {

  private final List<Integer> numbers;
  private final List<Operator> operators;

  public NumbersAndOperatorsGroup(List<Integer> numbers, List<Operator> operators) {
    this.numbers = numbers;
    this.operators = operators;
    validate();
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public List<Operator> getOperators() {
    return operators;
  }

  private void validate() {
    if (numbers.size() - operators.size() != 1) {
      throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");
    }
  }
}
