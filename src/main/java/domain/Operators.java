package domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Operators {

  private final Queue<String> operators;


  public Operators(Queue<String> operators) {
    this.operators = operators;
  }

  public Operators(String ...operators) {
    this(new LinkedList<>(Arrays.asList(operators)));
  }

  public String nextOperator() {
    return operators.poll();
  }

  public boolean isEmpty() {
    return operators.isEmpty();
  }
}
