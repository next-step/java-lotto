package calculator.v2;

public class Whitespace extends Token {

  public Whitespace(String token) {
    super(token, "[\\s]+");
  }
}
