package calculator;

public class TimesOperator implements Operator {

  public TimesOperator() {
  }

  @Override
  public Operand calculate(Operand op1, Operand op2) {
    return op1.times(op2);
  }
}
