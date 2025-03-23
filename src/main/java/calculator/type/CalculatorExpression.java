package calculator.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorExpression {

  List<String> splitExpression;

  public static CalculatorExpression valueOf(String expression) {
    return new CalculatorExpression(expression);
  }

  private CalculatorExpression(String expression) {
    if (expression == null) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    String trimmedExpression = expression.trim();

    if (trimmedExpression.isEmpty()) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    List<String> splitExpression =  List.of(trimmedExpression.split(" "));

    if (splitExpression.size() < 3) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    if (splitExpression.size() % 2 == 0) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    for (int i = 0 ; i < splitExpression.size(); i++) {
      String element = splitExpression.get(i);

      if (i % 2  == 0 && !isNumeric(element)) {
        throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
      }

      if (i % 2  == 1 && !isOperatorType(element)) {
        throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
      }
    }

    this.splitExpression = splitExpression;
  }

  private boolean isOperatorType(String str) {
    try {
      OperatorType.fromSymbol(str);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  private boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public InitialUnitExpression toInitialUnitExpression() {
    return InitialUnitExpression.valueOf(
        Integer.parseInt(splitExpression.get(0)),
        OperatorType.fromSymbol(splitExpression.get(1)),
        Integer.parseInt(splitExpression.get(2))
    );
  }

  public List<IntermediateUnitExpression> toIntermediateUnitExpressions() {
    if (splitExpression.size() < 3) {
      return Collections.emptyList();
    }

    List<IntermediateUnitExpression> res = new ArrayList<>();
    for (int i = 3; i < splitExpression.size() - 1; i += 2) {
      res.add(
          IntermediateUnitExpression.valueOf(
              OperatorType.fromSymbol(splitExpression.get(i)),
              Integer.parseInt(splitExpression.get(i + 1))
          )
      );
    }

    return res;
  }

}
