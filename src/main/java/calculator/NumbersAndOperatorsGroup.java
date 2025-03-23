package calculator;

import java.util.List;

public class NumbersAndOperatorsGroup {

  private final List<Integer> numbers;
  private final List<String> operators;

  public NumbersAndOperatorsGroup(List<Integer> numbers, List<String> operators) {
    this.numbers = numbers;
    this.operators = operators;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public List<String> getOperators() {
    return operators;
  }
}
