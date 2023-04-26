package stringcalculator;

import stringcalculator.domain.InputValue;
import stringcalculator.service.CalculateService;
import stringcalculator.ui.InputView;

public class Application {

  public static void main(String[] args) {
    InputValue input = InputView.input();
    int result = new CalculateService().calculate(input);

    System.out.println("결과 : " + result);
  }
}
