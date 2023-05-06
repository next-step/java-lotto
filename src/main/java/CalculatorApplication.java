import step1.Calculator;
import step1.Formula;
import step1.InputView;

import java.util.List;

public class CalculatorApplication {

    public static void main(String[] args) { // 1 + 2 * 3 / 2

        Formula formula = new Formula(InputView.insert());
        Calculator cal = new Calculator(formula);
        cal.init();
        System.out.println("계산 결과 = " + cal.execute());

    }
}
