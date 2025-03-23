package step1;

import step1.domain.Calculator;
import step1.domain.Expression;
import step1.view.InputView;
import step1.view.Outputview;

public class Main {
    public void run() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new Expression(InputView.input()));
        Outputview.result(result);
    }
}
