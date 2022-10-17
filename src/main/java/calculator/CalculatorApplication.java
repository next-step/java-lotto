package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {

  public static void main(String[] args) {
    Calculator cal = Calculator.from(InputView.input());
    OutputView.print(cal.execute());
  }
}
