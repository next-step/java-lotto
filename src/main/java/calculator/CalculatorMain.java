package calculator;

import calculator.domain.StringAddCalculator;

public class CalculatorMain {

  public static void main(String[] args) {
    int result = StringAddCalculator.splitAndSum("1:2:3");
    System.out.println(result);
  }
}
