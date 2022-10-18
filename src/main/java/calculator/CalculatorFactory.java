package calculator;

public class CalculatorFactory {
    private final static String ADDITION = "+";
    private final static String SUBTRACTION = "-";
    private final static String MULTIPLICATION = "*";
    private final static String DIVISION = "/";

    private CalculatorFactory() {
    }

    public static Calculator getCalculator(String arithmetic) {
        if (ADDITION.equals(arithmetic)) {
            return new AddCalculator();
        }
        if (SUBTRACTION.equals(arithmetic)) {
            return new SubtractCalculator();
        }
        if (MULTIPLICATION.equals(arithmetic)) {
            return new MultiplyCalculator();
        }
        return new DivideCalculator();
    }
}
