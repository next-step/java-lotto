package calculator;

import java.util.List;

public class Calculator {

  public int calculate(List<Token> tokens) {
    int result = tokens.get(0).toInt();
    for (int i = 1; i < tokens.size(); i += 2) {
      Token operator = tokens.get(i);
      Token operand = tokens.get(i + 1);
      result = calculate(result, operator, operand.toInt());
    }
    return result;
  }

  private int calculate(int left, Token operatorToken, int right) {
    Operator operator = Operator.fromSymbol(operatorToken.getValue());
    return operator.calculate(left, right);
  }
} 