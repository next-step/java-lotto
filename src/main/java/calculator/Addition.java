package calculator;

public class Addition implements Operation {

  @Override
  public int operate(int a, int b) {
    return a + b;
  }
}
