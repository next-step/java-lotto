package calculator;

import static calculator.exception.CustomExceptionCode.*;

public class Calculator {

    private static final String SPLITER = " ";

    private Calculator() {
    }

    public static int cal(String input) {
        isNullOrBlank(input);
        return calculate(input.split(SPLITER));
    }

    private static int calculate(String[] formulas) {
        int currentIdx = 0;
        int currentResult = Integer.parseInt(formulas[currentIdx++]);
        try {
            currentResult = repetitiveCalculation(formulas, currentIdx, currentResult);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INCOMPLETED_FORMULA.getMessage());
        }
        return currentResult;
    }

    private static int repetitiveCalculation(String[] formulas, int currentIdx, int currentResult) {
        while (currentIdx < formulas.length) {
            String operator = formulas[currentIdx++];
            int nextValue = Integer.parseInt(formulas[currentIdx++]);
            currentResult = Operator.calculate(currentResult, nextValue, operator);
        }
        return currentResult;
    }

    private static void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT.getMessage());
        }
    }
}
