package calculator;

import calculator.type.Expression;
import calculator.type.ExpressionUnit;

import java.util.List;

public class StringCalculator {

  public static int run(String expression) {
    Expression calculatorExpression = Expression.valueOf(expression);

    List<ExpressionUnit> expressionUnits = calculatorExpression.toIntermediateUnitExpressions();

    int res = calculatorExpression.getFirstOperand();
    for (ExpressionUnit expressionUnit : expressionUnits) {
      res = expressionUnit.run(res);
    }

    return res;
  }
}
