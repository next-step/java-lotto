package calculator.view;

import calculator.domain.Number;

public class CalculatorResultView {

  private static final String RESULT_MESSAGE = "계산 결과 : ";

  public void printResult(Number result) {
    System.out.println(RESULT_MESSAGE + result.getNumber());
  }
}
