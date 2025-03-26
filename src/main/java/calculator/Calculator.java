package calculator;

import util.InputValidator;

public class Calculator {
    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public int run(String input) {
        InputValidator.validateInput(input);
        return 0;
    }
}
