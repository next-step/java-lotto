package calculator;

import static calculator.exception.CustomExceptionCode.*;

public class Calculator {

    private static final String SPLITER = " ";

    private Calculator() {
    }

    public static int calculation(String input) {
        isNullOrBlank(input);
        return formulasCalculate(input.split(SPLITER));
    }

    private static int formulasCalculate(String[] formulas) {
        int currentIdx = 0;
        int currentResult = Integer.parseInt(formulas[currentIdx++]);
        try {
            currentResult = repetitiveCalculate(formulas, currentIdx, currentResult);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INCOMPLETED_FORMULA.getMessage());
        }
        return currentResult;
    }

    private static int repetitiveCalculate(String[] formulas, int currentIdx, int currentResult) {
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
