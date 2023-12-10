package calculator.application;

import calculator.domain.OperationType;

public class CalculatorService {
    private static final String DELIMITER = " ";

    public double calculate(String input) {
        String[] values = input.split(DELIMITER);
        String firstNumber = values[0];
        double result = Double.parseDouble(firstNumber);
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int right = Integer.parseInt(values[i + 1]);
            result = OperationType.getOperationType(operator)
                                  .getOperationResult(result, right);
        }
        return result;
    }
}

