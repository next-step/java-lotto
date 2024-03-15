package calculator;

import caculator.Calculator;
import caculator.Input;
import caculator.InputView;
import caculator.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculate() {
        final Input input = new Input(inputView.inputExpression());

        int result = Integer.parseInt(input.getByIndex(0));
        int index = 1;
        while (input.isIndexWithinBounds(index)) {
            result = Calculator.calculateTwoNumber(result, input.getByIndex(index), Integer.parseInt(input.getByIndex(index + 1)));
            index += 2;
        }

        outputView.printResult(result);
    }
}
