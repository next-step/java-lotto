package stringcalculator.service;

import stringcalculator.domain.InputValue;
import stringcalculator.factory.ExpressionFactory;

public class CalculateService {

  public int calculate(InputValue inputValue) {
    String[] expression = inputValue.split();
    return ExpressionFactory.create(expression).calculate();
  }
}
