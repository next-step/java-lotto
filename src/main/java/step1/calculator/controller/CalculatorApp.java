package step1.calculator.controller;

import java.util.stream.IntStream;
import step1.calculator.model.AddModule;
import step1.calculator.model.DivideModule;
import step1.calculator.model.MultiplyModule;
import step1.calculator.model.SubtractModule;
import step1.calculator.model.Validator;
import step1.calculator.view.InputView;
import step1.calculator.view.OutputView;

public class CalculatorApp {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Validator validator = new Validator();

    private static final AddModule addModule = new AddModule();
    private static final SubtractModule subtractModule = new SubtractModule();
    private static final MultiplyModule multiplyModule = new MultiplyModule();
    private static final DivideModule divideModule = new DivideModule();

    public void run() {
        String input = inputView.getInput();
        validator.validate(input);
        int result = calculates(input);
        outputView.print(result);
    }

    public int calculates(String input) {
        String[] tokens = input.split(" ");
        return calculates(tokens);
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
