package domain.operations;

import domain.operations.CalculateStrategy;
import domain.operations.Number;
import domain.operations.OperationStrategies;
import domain.operations.enums.OperationEnum;

public class StringCalculation {
    private final static String GAP = " ";

    public static String[] splitByGap(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("문자열이 입력안됐거나 공백 문자열 입니다.");
        }
        return str.split(GAP);
    }

    public static int getSum(String input) {
        String[] strings = splitByGap(input);

        int sum = 0;
        for (int i = 1; i < strings.length; i += 2) {
            sum = calculateV2(strings, sum, i);
        }
        return sum;
    }

    private static int calculate(String[] strings, int sum, int i) {
        CalculateStrategy operation = OperationStrategies.getOperation(strings[i]);
        if (i == 1) {
            sum += operation.calculate(new Number(strings[i - 1]), new Number(strings[i + 1]));
            return sum;
        }
        return operation.calculate(new Number(sum), new Number(strings[i + 1]));
    }

    private static int calculateV2(String[] strings, int sum, int operationIndex) {
        if (operationIndex == 1) {
            sum += OperationEnum.calculate(strings[operationIndex], new Number(strings[operationIndex - 1]), new Number(strings[operationIndex + 1]));
            return sum;
        }
        return OperationEnum.calculate(strings[operationIndex], new Number(sum), new Number(strings[operationIndex + 1]));
    }
}
