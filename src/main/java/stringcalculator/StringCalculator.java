package stringcalculator;

public class StringCalculator {
    private static final int GO_TO_END_OF_CALCULATION = 2;

    private StringCalculator() {}

    public static String splitAndCalculate(StringExpression expression) {
        String[] calculations = expression.split();
        final int sizeOfCalculations = calculations.length;

        for (int i = 0; i < sizeOfCalculations - 2; i += GO_TO_END_OF_CALCULATION) {
            calculations[i+2] = Operator.calculate(calculations[i+1], calculations[i], calculations[i+2]);
        }

        return calculations[sizeOfCalculations-1];
    }
}
