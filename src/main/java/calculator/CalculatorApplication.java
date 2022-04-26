package calculator;

import calculator.model.Number;
import calculator.util.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {
    public static void main(String[] args) {
        new CalculatorApplication().run(args);
    }

    private void run(String[] args) {
        String command = InputView.getCommand();
        Number result = Calculator.calculate(command);
        ResultView.print(result);
    }
}
