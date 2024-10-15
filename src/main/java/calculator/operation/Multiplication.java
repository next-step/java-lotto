package calculator.operation;

public class Multiplication implements Operation {

  @Override
  public int perform(int operand1, int operand2) {
    return operand1 * operand2;
  }
}
