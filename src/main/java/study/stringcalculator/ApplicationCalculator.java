package study.stringcalculator;

import study.stringcalculator.domain.InputValue;
import study.stringcalculator.service.CalculateService;
import study.stringcalculator.ui.InputView;

public class ApplicationCalculator {

  public static void main(String[] args) {
    InputValue input = InputView.input();
    int result = new CalculateService().calculate(input);

    System.out.println("결과 : " + result);
  }
}
