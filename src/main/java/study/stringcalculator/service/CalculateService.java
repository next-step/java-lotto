package study.stringcalculator.service;

import study.stringcalculator.domain.InputValue;
import study.stringcalculator.factory.ExpressionFactory;

public class CalculateService {

  public int calculate(InputValue inputValue) {
    String[] expression = inputValue.split();
    return ExpressionFactory.create(expression).calculate();
  }
}
