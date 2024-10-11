import domain.Calculator;
import view.InputView;
import view.ResultView;

public class CalculatorMachine {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Calculator calculator = new Calculator();
    public void start() {
        String input = inputView.getInput();
        int result = calculator.calculate(input);
        resultView.printResult(result);
    }
}
