package study;

public class CalculatorInput {
    private final String calculatorString;

    CalculatorInput(String string) {
        calculatorString = string;
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
