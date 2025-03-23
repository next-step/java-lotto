package calculator;

import calculator.type.CalculatorExpression;
import calculator.type.InitialUnitExpression;
import calculator.type.IntermediateUnitExpression;

import java.util.List;

public class StringCalculator {

  public static int run(String expression) {
    CalculatorExpression calculatorExpression = CalculatorExpression.valueOf(expression);

    InitialUnitExpression initialUnitExpression = calculatorExpression.toInitialUnitExpression();
    List<IntermediateUnitExpression> intermediateUnitExpressions = calculatorExpression.toIntermediateUnitExpressions();

    int res = initialUnitExpression.run();
    for (IntermediateUnitExpression intermediateUnitExpression : intermediateUnitExpressions) {
      res = intermediateUnitExpression.run(res);
    }

    return res;
  }
}
