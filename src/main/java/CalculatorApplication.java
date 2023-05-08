import step1.Calculator;
import step1.InputView;

public class CalculatorApplication {

    public static void main(String[] args) { // 1 + 2 * 3 / 2

        Calculator calculator = new Calculator(InputView.insert());
        calculator.init();
        calculator.printResult();
    }
}
