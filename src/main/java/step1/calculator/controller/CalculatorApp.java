package step1.calculator.controller;

import java.util.stream.IntStream;
import step1.calculator.model.AddModule;
import step1.calculator.model.DivideModule;
import step1.calculator.model.MultiplyModule;
import step1.calculator.model.SubtractModule;
import step1.calculator.view.InputView;
import step1.calculator.view.OutputView;

public class CalculatorApp {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final AddModule addModule = new AddModule();
    private static final SubtractModule subtractModule = new SubtractModule();
    private static final MultiplyModule multiplyModule = new MultiplyModule();
    private static final DivideModule divideModule = new DivideModule();

    public void run() {
        String input = inputView.getInput();
        validate(input);

        String[] tokens = input.split(" ");
        validate(tokens);

        int result = calculates(tokens);

        outputView.print(result);
    }

    private void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(String[] tokens) {
        if (tokens == null || tokens.length / 2 == 0) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, tokens.length).filter(i -> i % 2 == 0).filter(i -> !isNumber(tokens[i])).findFirst()
            .ifPresent(i -> {
                throw new IllegalArgumentException();
            });
        IntStream.range(0, tokens.length).filter(i -> i % 2 == 1).filter(i -> !isOperator(tokens[i])).findFirst()
            .ifPresent(i -> {
                throw new IllegalArgumentException();
            });
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int calculates(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = calculate(result, tokens[i], Integer.parseInt(tokens[i + 1]));
        }
        return result;
    }

    private int calculate(int result, String operator, int number) {
        switch (operator) {
            case "+":
                return addModule.calculate(result, number);
            case "-":
                return subtractModule.calculate(result, number);
            case "*":
                return multiplyModule.calculate(result, number);
            case "/":
                return divideModule.calculate(result, number);
            default:
                throw new IllegalArgumentException();
        }
    }

}
