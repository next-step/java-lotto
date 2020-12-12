package study;

import java.util.List;

public class CalculatorInput {
    private final String calculatorString;

    CalculatorInput(String string) {
        calculatorString = string;
    }

    protected List<String> strings() {
        return Splitter.split(calculatorString);
    }

    protected boolean isUnusable() {
        return isNull() || isEmpty();
    }

    private boolean isEmpty() {
        return calculatorString.isEmpty();
    }

    private boolean isNull() {
        return calculatorString == null;
    }
}
