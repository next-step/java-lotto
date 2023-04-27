package stringCalculator;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {
  private final Queue<Operator> operators;
  private final Queue<Number> numbers;

  public Expression(Queue<Operator> operators, Queue<Number> numbers) {
    this.operators = new LinkedList<>(operators);
    this.numbers = new LinkedList<>(numbers);
  }

  public Number evaluate() {
    Number result = numbers.poll();
    while (!operators.isEmpty()) {
      result = operators.poll().calculate(result, numbers.poll());
    }
    return result;
  }
}
