package calculator;

import calculator.domain.Calculator;
import calculator.exception.WrongCalculationException;
import calculator.model.Operands;
import calculator.model.Operators;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorMachine {
    private final InputView inputView;
    private final ResultView resultView = new ResultView();
    private final Calculator calculator;

    public CalculatorMachine(Operands operands, Operators operators) {
        this.inputView = new InputView(operands, operators);
        this.calculator = new Calculator(operands, operators);
    }
    public void start() throws WrongCalculationException {
        inputView.receiveInput();
        int result = calculator.calculate();
        resultView.printResult(result);
    }
}
