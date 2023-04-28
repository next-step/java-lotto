package stringCalculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Expression {
  private final List<Operator> operators;
  private final List<Number> numbers;

  public Expression(List<Operator> operators, List<Number> numbers) {
    this.operators = new ArrayList<>(operators);
    this.numbers = new ArrayList<>(numbers);
  }

  public Number evaluate() {
    Number result = numbers.get(0);
    for (int operatorIndex = 0, numbersIndex = 1; operatorIndex < operators.size(); operatorIndex++, numbersIndex++) {
      result = operators.get(operatorIndex).calculate(result, numbers.get(numbersIndex));
    }

    return result;
  }
}
