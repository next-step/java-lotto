package stringcalculator;

import stringcalculator.service.CalculateService;
import stringcalculator.service.InputService;

public class Application {

  public static void main(String[] args) {
    int result = new CalculateService().calculate(new InputService().input());

    System.out.println("결과 : " + result);
  }
}
