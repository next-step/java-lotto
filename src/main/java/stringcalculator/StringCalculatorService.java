package stringcalculator;

public class StringCalculatorService {

    private static final String DELIMITER = " ";
    public static final int INIT_INDEX = 0;

    private CalculationValidation calculationValidation;
    private Calculator calculator;

    public StringCalculatorService() {
        this.calculationValidation = new CalculationValidation();
    }

    public double startCalculation(String input) {
        String[] numAndSymbols = splitInput(input);
        initCalculator(numAndSymbols);

        return repeatCalculation(numAndSymbols);
    }

    private String[] splitInput(String input) {
        String[] numAndSymbols = input.split(DELIMITER);
        calculationValidation.validate(numAndSymbols);

        return numAndSymbols;
    }

    private void initCalculator(String[] numAndSymbols) {
        calculator = new Calculator(Double.parseDouble(numAndSymbols[INIT_INDEX]));
    }

    private double repeatCalculation(String[] numAndSymbols) {
        double sum = 0;

        for (int i = 1; i < numAndSymbols.length; i+=2) {
            sum  += calculateBy(numAndSymbols[i], numAndSymbols[i + 1]);
        }

        return sum;
    }

    private double calculateBy(String symbol, String next) {
        double result = calculator.calculateBy(symbol, Double.parseDouble(next));

        if (calculator.isDivision(symbol)) {
            return Math.round(result);
        }

        return Math.round(result * 100) / 100.0;
    }
}
