package step1.calc;

import java.util.List;
import step1.calc.calculator.Calculator;
import step1.calc.operand.Operand;
import step1.calc.view.InputView;
import step1.calc.view.ResultView;

public class Main {

    public static void main(String[] args) {
        List<String> expression = InputView.getExpression();
        Calculator calculator = new Calculator();
        Operand result = calculator.calculate(expression);
        ResultView.printResult(result);
    }
}
