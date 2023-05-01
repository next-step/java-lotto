package study.stringcalculator;

import study.stringcalculator.domain.Expression;
import study.stringcalculator.domain.InputValue;
import study.stringcalculator.factory.ExpressionFactory;
import study.stringcalculator.ui.InputView;

public class ApplicationCalculator {

  public static void main(String[] args) {
    InputValue inputValue = InputView.inputValue();
    Expression expression = ExpressionFactory.create(inputValue);
    System.out.println("결과 : " + expression.calculate());
  }
}
