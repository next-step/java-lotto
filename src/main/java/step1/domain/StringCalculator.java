package step1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private final Equation equation;

    public StringCalculator(Equation equation) {
        this.equation = equation;
    }

    public static StringCalculator of(String rawEquation) {
        return new StringCalculator(Equation.of(rawEquation));
    }

    public Number calculate() {
        return equation.calculate();
    }
}
