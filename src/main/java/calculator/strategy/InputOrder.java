package calculator.strategy;

import calculator.enumeration.OperationSymbol;

public class InputOrder implements CalculationOrderStrategy {
    public static final int FIRST_INDEX = 0;

    @Override
    public int calculate(final String[] values) {
        int result = Integer.parseInt(values[FIRST_INDEX]);
        for (int operatorIndex = 1; operatorIndex < values.length - 1; operatorIndex += 2) {
            int rightIndex = operatorIndex + 1;
            final int right = Integer.parseInt(values[rightIndex]);
            OperationSymbol operationSymbol = OperationSymbol.from(values[operatorIndex]);
            result = operationSymbol.calculate(result, right);
        }
        return result;
    }
}
