package calculator.service;

import calculator.domain.CalcNumber;
import calculator.domain.OperatorFactory;
import calculator.domain.SeparatorExpression;

import java.util.List;

public class StringCalculatorService {
    private static final int FIRST_INPUT_INDEX = 0;

    private StringCalculatorService() {
    }

    public static int calculate(String input) {
        List<String> operations = SeparatorExpression.getOperations(input);
        int result = new CalcNumber(operations.get(FIRST_INPUT_INDEX)).number();
        for (int i = 2; i < operations.size(); i += 2) {
            int nextNum = new CalcNumber(operations.get(i)).number();
            result = OperatorFactory
                    .valueOf(operations.get(i - 1))
                    .apply(result, nextNum);
        }
        return result;
    }
}
