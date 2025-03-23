package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersAndOperatorsGroup {

  private final List<Integer> numbers;
  private final List<Operator> operators;

  public NumbersAndOperatorsGroup(List<Integer> numbers, List<String> operators) {
    this.numbers = numbers;
    this.operators = operators.stream().map(Operator::from).collect(Collectors.toList());
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public List<Operator> getOperators() {
    return operators;
  }
}
