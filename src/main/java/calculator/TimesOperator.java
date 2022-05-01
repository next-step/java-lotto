package calculator;

public class TimesOperator implements Operator {

  public TimesOperator() {
  }

  @Override
  public int calculate(int op1, int op2) {
    return op1 * op2;
  }
}
