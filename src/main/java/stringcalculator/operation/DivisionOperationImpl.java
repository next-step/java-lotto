package stringcalculator.operation;

public class DivisionOperationImpl implements Operation {

  @Override
  public int apply(int acc, int value) {
    return acc / value;
  }
}
