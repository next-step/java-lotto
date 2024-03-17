import controller.Calculator;
import model.Validator;
import view.InputView;
import view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputView(new Validator()), new ResultView());
        calculator.start();
    }
}
