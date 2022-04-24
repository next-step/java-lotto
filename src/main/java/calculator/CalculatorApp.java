package calculator;

import calculator.domain.Calculator;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorResultView;

public class CalculatorApp {

  public static void main(String[] args) {
    CalculatorInputView calculatorInputView = new CalculatorInputView();
    calculatorInputView.printInputMessage();
    String formula = calculatorInputView.getInputFormula();

    Calculator calculator = new Calculator();

    CalculatorResultView calculatorResultView = new CalculatorResultView();
    calculatorResultView.printResult(calculator.calc(formula));
  }
}
