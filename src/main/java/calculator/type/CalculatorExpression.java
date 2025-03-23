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
    if (isExpressionNullOrEmpty(expression)) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    List<String> splitExpression = List.of(expression.trim().split(" "));

    if (isNotValidFormat(splitExpression) || isNotValidElement(splitExpression)) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    this.splitExpression = splitExpression;
  }

  private boolean isExpressionNullOrEmpty(String expression) {
    if (expression == null) {
      return true;
    }

    return expression.trim().isEmpty();
  }

  private boolean isNotValidFormat(List<String> splitExpression) {
    return splitExpression.size() < 3 || splitExpression.size() % 2 == 0;
  }

  private boolean isNotValidElement(List<String> splitExpression) {
    for (int i = 0; i < splitExpression.size(); i++) {
      String element = splitExpression.get(i);

      if ((i % 2 == 0 && !isNumeric(element)) || i % 2 == 1 && !isOperatorType(element)) {
        return true;
      }
    }

    return false;
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
