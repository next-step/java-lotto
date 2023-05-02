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
        List<String> equation = Arrays.stream(rawEquation.split(" "))
                .map(String::trim)
                .collect(Collectors.toList());
        return new StringCalculator(new Equation(equation));
    }

    public Number calculate() {
        return equation.calculate();
    }
}
