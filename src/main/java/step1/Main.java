package step1;

import step1.domain.Calculator;
import step1.domain.Expression;
import step1.util.ExpressionTokens;
import step1.view.InputView;
import step1.view.Outputview;

import java.util.List;

public class Main {
    public void run() {
        Calculator calculator = new Calculator();
        List<String> split = ExpressionTokens.parseTokens(InputView.input());
        int result = calculator.calculate(new Expression(split));
        Outputview.result(result);
    }
}
