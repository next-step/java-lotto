package calculator.v2;

import calculator.Splitter;
import java.util.ArrayList;
import java.util.List;

public class Lexer {

  private Lexer() {
  }

  public static List<Token> lex(String input) {
    ArrayList<Token> result = new ArrayList<>();
    List<String> split = Splitter.split(input);
    for (String s : split) {
      Token token = TokenFactory.createToken(s);
      if (token instanceof Whitespace) {
        continue;
      }
      result.add(token);
    }
    return result;
  }
}
