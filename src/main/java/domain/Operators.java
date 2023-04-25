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
    this.operators = new LinkedList<>();
    this.operators.addAll(Arrays.asList(operators));
  }

  public String poll() {
    return operators.poll();
  }
}
