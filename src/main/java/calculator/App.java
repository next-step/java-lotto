package calculator;

import calculator.domain.Calculator;
import calculator.domain.ExpressionParser;
import calculator.view.CalculatorInput;
import calculator.view.InputView;
import calculator.view.ResultView;

public class App {
    public static void main(String[] args) {
        String input = InputView.scanInput();
        CalculatorInput calculatorInput =  new ExpressionParser(input).parseOperator();

        int result = new Calculator(calculatorInput.getInit(), calculatorInput.getOperators()).calculate();
        ResultView.printResult(result);
    }
}
