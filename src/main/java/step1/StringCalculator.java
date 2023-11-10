package step1;

public class StringCalculator {

    private static final String DELIMITER = " ";

    private double sum;
    private InputValidation inputValidation;

    public StringCalculator () {
        this.sum = 0;
        this.inputValidation = new InputValidation();
    }

    public double calculate(String input) {
        String[] numAndSymbols = splitInput(input);

        initSum(numAndSymbols);
        repeatCalculation(numAndSymbols);

        return sum;
    }

    private String[] splitInput(String input) {
        String[] numAndSymbols = input.split(DELIMITER);
        inputValidation.validate(numAndSymbols);

        return numAndSymbols;
    }

    private void initSum(String[] numAndSymbols) {
        sum = Double.parseDouble(numAndSymbols[0]);
    }

    private void repeatCalculation(String[] numAndSymbols) {
        for (int i = 1; i < numAndSymbols.length; i+=2) {
            sum  = calculateWithSymbol(numAndSymbols[i], numAndSymbols[i + 1]);
        }
    }

    private double calculateWithSymbol(String symbol, String next) {
        double nextNum = Double.parseDouble(next);

        if (OperationSymbol.isDivision(symbol)) {
            return Math.round(sum / nextNum);
        }

        calculateWithPlus(symbol, nextNum);
        calculateWithMinus(symbol, nextNum);
        calculateWithMultiplication(symbol, nextNum);

        return Math.round(sum * 100) / 100.0;
    }

    private void calculateWithPlus(String symbol, double nextNum) {
        if (OperationSymbol.isPlus(symbol)) {
            sum += nextNum;
        }
    }

    private void calculateWithMinus(String symbol, double nextNum) {
        if (OperationSymbol.isMinus(symbol)) {
            sum -= nextNum;
        }
    }

    private void calculateWithMultiplication(String symbol, double nextNum) {
        if (OperationSymbol.isMultiplication(symbol)) {
            sum *= nextNum;
        }
    }
}
