package stringcalculator;

import java.util.function.DoubleBinaryOperator;

public class StringCalculator {

    private static final String DELIMITER = " ";
    public static final int INIT_NUMBER = 0;

    private String[] numAndSymbols;

    public double startCalculation(String input) {
        initNumAndSymbols(input);
        CalculationValidator.validate(numAndSymbols);

        return repeatCalculation();
    }

    private void initNumAndSymbols(String input) {
        numAndSymbols = input.split(DELIMITER);
    }

    private double repeatCalculation() {
        double sum = initFirstValue();

        for (int positionIdx = 1; positionIdx < numAndSymbols.length; positionIdx += 2) {
            sum = calculateWithFolmula(sum, positionIdx);
        }

        return sum;
    }

    private double initFirstValue () {
        return Double.parseDouble(numAndSymbols[INIT_NUMBER]);
    }

    private double calculateWithFolmula(double left, int positionIdx) {
        DoubleBinaryOperator folmula = OperationSymbols.findFolmula(numAndSymbols[positionIdx]);
        double sum = folmula.applyAsDouble(left, Double.parseDouble(numAndSymbols[positionIdx + 1]));

        return roundsNumber(sum, positionIdx);
    }

    private double roundsNumber(double sum, int positionIdx) {
        if (OperationSymbols.isDivision(numAndSymbols[positionIdx])) {
            return Math.round(sum);
        }

        return Math.round(sum * 100) / 100.0;
    }
}