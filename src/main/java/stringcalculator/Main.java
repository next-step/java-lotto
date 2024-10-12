package stringcalculator;

import stringcalculator.model.Expression;
import stringcalculator.model.Number;
import stringcalculator.service.StringCalculatorService;
import stringcalculator.ui.input.ConsoleInputView;
import stringcalculator.ui.input.InputView;
import stringcalculator.ui.output.ConsoleOutputView;
import stringcalculator.ui.output.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        StringCalculatorService service = new StringCalculatorService();
        OutputView outputView = new ConsoleOutputView();

        Expression expression = inputView.getExpression();

        Number number = service.calculate(expression);

        outputView.printResult(number);

    }
}
