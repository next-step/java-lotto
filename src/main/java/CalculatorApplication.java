import calculator.domain.Calculator;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorApplication {
    public static void main(String[] args) {
        int result = Calculator.from(Input.express());
        Output.print(result);
    }
}
