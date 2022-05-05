package calculator.v2;

public class Operator extends Token {

  public Operator(String input) {
    super(input, "[+\\-\\*\\/]");
  }
}
