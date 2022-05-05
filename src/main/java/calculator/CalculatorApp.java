package calculator;

import calculator.domain.Calculator;
import lotto.domain.strategy.view.CalculatorInputView;
import lotto.domain.strategy.view.CalculatorResultView;

public class CalculatorApp {

  public static void main(String[] args) {
    CalculatorInputView calculatorInputView = new CalculatorInputView();
    calculatorInputView.printInputMessage();
    String formula = calculatorInputView.getInputFormula();

    Calculator calculator = new Calculator();

    CalculatorResultView.printResult(calculator.calc(formula));
  }
}
