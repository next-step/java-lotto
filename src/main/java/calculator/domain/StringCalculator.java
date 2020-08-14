package calculator.domain;

import java.util.Objects;

public class Calculator {
    private static Calculator calculator = null;

    private Calculator() {}

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }


}
