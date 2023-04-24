package stringcalculator;

public class Calculator {

  private Input input;

  public Calculator(String input) {
    this(new Input(input));
  }

  private Calculator(Input input) {
    this.input = input;
  }
}
