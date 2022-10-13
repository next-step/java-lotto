package calculator.service;

import calculator.domain.CalcNumber;
import calculator.domain.CalcOperator;

import java.util.List;

public class StringCalculatorService {
    private static final int FIRST_INPUT_INDEX = 0;
    private static final String SEPARATOR = " ";
    private static final String NO_INPUT_MESSAGE = "입력값이 없습니다.";

    private StringCalculatorService() {
    }

    public static List<String> getOperations(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(NO_INPUT_MESSAGE);
        }
        return List.of(input.split(SEPARATOR));
    }

    public static CalcNumber calculate(List<String> operations) {
        CalcNumber result = new CalcNumber(operations.get(FIRST_INPUT_INDEX));
        for (int i = 2; i < operations.size(); i += 2) {
            CalcOperator operator = new CalcOperator(operations.get(i - 1));
            CalcNumber nextNum = new CalcNumber(operations.get(i));
            result = operator.operate().calculate(result, nextNum);
        }
        return result;
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
