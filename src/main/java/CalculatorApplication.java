import calculator.Calculator;
import view.Input;
import view.Output;

public class CalculatorApplication {
    public static void main(String[] args) {
        int result = Calculator.from(Input.express());
        Output.print(result);
    }
}
