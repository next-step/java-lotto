package calculator;

import calculator.domain.Calculator;
import calculator.domain.PreProcessor;
import calculator.exception.WrongCalculationException;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorMachine {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final PreProcessor preProcessor = new PreProcessor();
    private Calculator calculator;

    public void start() throws WrongCalculationException {
        String input = inputView.receiveInput();
        preProcessor.process(input);
        this.calculator = new Calculator(preProcessor.getOperands(), preProcessor.getOperators());
        int result = calculator.calculate();
        resultView.printResult(result);
    }
}
