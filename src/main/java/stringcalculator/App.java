package stringcalculator;

import static stringcalculator.InputValidator.validateInput;

public class App {

    private App() {
    }

    public static int calculate(String input) {
        validateInput(input);
        return new StringCalculator(input).calculate();
    }
}
