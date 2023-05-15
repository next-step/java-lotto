package stringcalculator.domain;

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
