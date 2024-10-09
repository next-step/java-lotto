import domain.Calculator;
import view.InputView;
import view.ResultView;

public class CalculatorMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Calculator calculator = new Calculator();

        String input = inputView.getInput();
        int result = calculator.calculate(input);
        resultView.printResult(result);
    }
}
