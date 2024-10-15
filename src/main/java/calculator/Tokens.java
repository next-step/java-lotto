package calculator;

import calculator.operation.Operation;
import java.util.List;

public class Tokens {

  private final List<Token> tokens;

  public Tokens(List<Token> tokens) {
    this.tokens = tokens;
  }

  public int evaluate() {
    int result = tokens.get(0).asOperand();

    for (int i = 1; i < tokens.size(); i += 2) {
      Operation operation = tokens.get(i).asOperator();
      int nextOperand = tokens.get(i + 1).asOperand();
      result = operation.perform(result, nextOperand);
    }

    return result;
  }
}
