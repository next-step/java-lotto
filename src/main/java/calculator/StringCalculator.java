package calculator;

import calculator.domain.ArithmeticProcessor;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;


public class StringCalculator {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StringCalculator() {
        this.inputHandler = new ConsoleInputHandler();
        this.outputHandler = new ConsoleOutputHandler();
    }

    public void run() {
        outputHandler.showCommentForArithmeticOperationText();

        try {
            String[] arithmeticExpressionFromUser = inputHandler.getArithmeticExpressionFromUser();

            int result = ArithmeticProcessor.processExpression(arithmeticExpressionFromUser);

            outputHandler.showSimpleMessage(String.valueOf(result));
        } catch (Exception e) {
            outputHandler.showExceptionMessage(e);
        }
    }

}
