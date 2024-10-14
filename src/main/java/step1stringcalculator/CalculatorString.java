package step1stringcalculator;

import java.util.Objects;

public class CalculatorString {
    private final String calculatorString;

    public CalculatorString(String calculatorString) {
        this.calculatorString = calculatorString;
    }

    public void checkNullAndEmpty() {
        if (Objects.isNull(calculatorString) || calculatorString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
