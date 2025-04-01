package stringcalculator.operation;

public class AddOperationImpl implements Operation {

  @Override
  public int apply(int acc, int value) {
    return acc + value;
  }
}
