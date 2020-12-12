package study;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorInput {
    private final String calculatorString;

    CalculatorInput(String string) {
        calculatorString = string;
    }

    protected List<Integer> ints() {
        return strings().stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<String> strings() {
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
