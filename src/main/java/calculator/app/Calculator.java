package calculator.app;

import calculator.domain.MathematicalExpressions;
import utils.StringSplitter;

public class Calculator {
    private static final String DELIMITER = " ";

    public int calculate(String expression) {
        return MathematicalExpressions
                .from(StringSplitter.split(expression, DELIMITER))
                .result();
    }
}
