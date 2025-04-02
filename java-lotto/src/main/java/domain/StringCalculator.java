package domain;

import ui.InputView;
import ui.OutputView;

public class StringCalculator {
    public final InputView inputView;
    public final OutputView outputView;

    public StringCalculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public int calculate(String input) {
        inputView.validateInput(input);
        String[] tokens = inputView.readAndSplitInput();

        return evaluate(tokens);
    }

    private int evaluate(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);
            result = applyOperation(result, operator, operand);
        }
        return result;
    }

    private int applyOperation(int left, String operator, int right) {
        return switch (operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> {
                if (right == 0) throw new ArithmeticException("Cannot divide by zero");
                yield left / right;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}