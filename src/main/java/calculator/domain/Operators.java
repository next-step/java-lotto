package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operators {
  private final Queue<Operator> operators;

  public Operators(Queue<Operator> operators) {
    this.operators = operators;
  }

  public static Operators of(List<String> operators) {
    Queue<Operator> operatorList = new LinkedList<>();

    for (String operator : operators) {
      operatorList.add(Operator.valueOfOperator(operator));
    }

    return new Operators(operatorList);
  }

  public Operator next() {
    return operators.poll();
  }
}
