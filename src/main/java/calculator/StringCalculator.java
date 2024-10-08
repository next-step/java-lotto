package calculator;

import calculator.domain.Operator;
import calculator.domain.OperatorFinder;
import calculator.exception.ApplicationException;
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
            String[] operandsAndOperators = inputHandler.getArithmeticExpressionFromUser();

            process(operandsAndOperators);
        } catch (ApplicationException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception e) {
            outputHandler.showSimpleMessage("계산기에 문제가 생겼습니다.");
        }
    }

    private void process(String[] operandsAndOperators) {
        int result = Integer.parseInt(operandsAndOperators[0]);

        for (int i = 1; i < operandsAndOperators.length; i += 2) {
            result = calculate(OperatorFinder.findOperator(operandsAndOperators[i]), result, Integer.parseInt(operandsAndOperators[i + 1]));
        }

        outputHandler.showSimpleMessage(String.valueOf(result));
    }

    private int calculate(Operator operator, int operand1, int operand2) {
        return operator.calculate(operand1, operand2);
    }
}
