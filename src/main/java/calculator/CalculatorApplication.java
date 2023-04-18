package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class CalculatorApplication {
  public static void main(String[] args) {
    List<String> operations = InputView.inputOperation();

    Calculator calculator = Calculator.createCalculator(operations);

    ResultView.show(calculator.calculate());
  }
}
