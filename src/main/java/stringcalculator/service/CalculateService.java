package stringcalculator.service;

import stringcalculator.domain.InputValue;
import stringcalculator.factory.ExpressionFactory;
import stringcalculator.factory.OperatorFactory;

public class CalculateService {

  ExpressionFactory expressionFactory;
  OperatorFactory operatorFactory;

  public CalculateService() {
    this(new ExpressionFactory(), new OperatorFactory());
  }

  public CalculateService(final ExpressionFactory expressionFactory,
      final OperatorFactory operatorFactory) {
    this.expressionFactory = expressionFactory;
    this.operatorFactory = operatorFactory;
  }

  public int calculate(InputValue inputValue) {
    return expressionFactory.create(inputValue.split()).calculate(operatorFactory);
  }
}
