package step1.calc;

import step1.calc.calculator.Calculator;
import step1.calc.view.InputView;
import step1.calc.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String[] expression = InputView.getExpression();
        Calculator calculator = new Calculator(expression);
        ResultView resultView = new ResultView(calculator);
        resultView.printResult();
    }
}
