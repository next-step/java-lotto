package step1;

import step1.domain.Calculator;
import step1.exception.WrongCalculationException;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculatorMachine {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final Calculator calculator = new Calculator();

    public void start() throws WrongCalculationException {
        inputView.receiveInput();
        int result = calculator.calculate();
        resultView.printResult(result);
    }
}
