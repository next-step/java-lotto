package calculator.view;

import static calculator.config.CalculatorExceptionMessage.UNEXPECTED_EXCEPTION;

import calculator.util.ExpressionParser;
import calculator.view.io.Input;
import calculator.view.io.Output;

public class CalculatorView {

    private final Input input;
    private final Output output;

    public CalculatorView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public String[] readExpressionTokens() {
        return ExpressionParser.parseToTokens(input.readLine());
    }

    public void printBusinessExceptionMessage(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        output.printLine(UNEXPECTED_EXCEPTION.message());
    }
}
