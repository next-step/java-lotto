package calculator.view;

import static calculator.config.CalculatorExceptionMessage.UNEXPECTED_EXCEPTION;

import java.text.MessageFormat;

import calculator.domain.Operand;
import calculator.util.ExpressionParser;
import calculator.view.io.Input;
import calculator.view.io.Output;

public class CalculatorView {

    private static final String EXPRESSION_INPUT_MESSAGE = "계산식을 입력해주세요.";
    private static final String RESULT_PRINT_FORMAT = "계산 결과 : {0}";

    private final Input input;
    private final Output output;

    public CalculatorView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public String[] readExpressionTokens() {
        output.printLine(EXPRESSION_INPUT_MESSAGE);

        return ExpressionParser.parseToTokens(input.readLine());
    }

    public void printCalculationResult(final Operand result) {
        output.printLine(MessageFormat.format(RESULT_PRINT_FORMAT, result));
    }

    public void printBusinessExceptionMessage(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        output.printLine(UNEXPECTED_EXCEPTION.message());
    }
}
