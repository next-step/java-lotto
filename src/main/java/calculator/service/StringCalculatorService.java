package calculator.service;

import calculator.domain.CalcNumber;
import calculator.domain.CalcOperator;
import calculator.domain.SeparatorExpression;

import java.util.List;

public class StringCalculatorService {
    private static final int FIRST_INPUT_INDEX = 0;

    private StringCalculatorService() {
    }

    public static CalcNumber calculate(String input) {
        List<String> operations = SeparatorExpression.getOperations(input);
        CalcNumber result = new CalcNumber(operations.get(FIRST_INPUT_INDEX));
        for (int i = 2; i < operations.size(); i += 2) {
            CalcNumber nextNum = new CalcNumber(operations.get(i));
            result = CalcOperator.operate(operations.get(i - 1)).calculate(result, nextNum);
        }
        return result;
    }
}
