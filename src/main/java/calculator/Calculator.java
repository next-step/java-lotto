package calculator;

import calculator.validator.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

  public static int calculate(String input) {
    InputValidator.validateInput(input);
    Tokens tokens = parseToken(input);

    return tokens.evaluate();
  }

  private static Tokens parseToken(String input) {
    List<Token> tokens = Arrays.stream(input.split(" "))
        .map(Token::new)
        .collect(Collectors.toList());
    return new Tokens(tokens);
  }
}