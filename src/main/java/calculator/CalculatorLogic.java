package calculator;

public class CalculatorLogic {
    private static final String DELIMITER = " ";

    public static int calculatorLogic(String inputString) {
        if (isValidInputString(inputString))
            throw new IllegalArgumentException("빈 값입니다.");

        String[] splitResult = inputString.split(DELIMITER);

        return calculateResultNumber(splitResult, initFirstNumber(splitResult[0]));
    }

    private static int calculateResultNumber(String[] splitResult, int resultNumber) {
        for (int i = 1; i < splitResult.length; i += 2) {
            String symbol = splitResult[i];
            int number = Integer.parseInt(splitResult[i + 1]);
            Calculator cal = Calculator.findSymbol(symbol);
            resultNumber = cal.calculate(resultNumber, number);
        }
        return resultNumber;
    }

    private static int initFirstNumber(String firstNumber) {
        try {
            return Integer.parseInt(firstNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수값이 아닙니다.");
        }
    }

    private static boolean isValidInputString(String inputString) {
        return inputString.isBlank();
    }
}
