package calculator;

import java.util.List;

import caculator.Calculator;
import caculator.InputView;
import caculator.OutputView;
import caculator.Util;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculate() {
        final List<String> inputs = Util.split(inputView.inputExpression());

        int result = Integer.parseInt(inputs.get(0));
        int index = 1;
        while (index < inputs.size()) {
            result = Calculator.calculateTwoNumber(result, inputs.get(index), Integer.parseInt(inputs.get(index + 1)));
            index += 2;
        }

        outputView.printResult(result);
    }

    public static void validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
