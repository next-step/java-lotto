package calculator.v2;

public class Operand extends Token {

  public Operand(String input) {
    super(input, "[0-9]+");
  }
}
