package calculator.domain;

import calculator.util.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    public static Number calc(String strOperation) {
        validateStringOperation(strOperation);

        Queue<String> operatorSequence = new ArrayDeque<>(List.of(split(strOperation)));
        Number firstValue = new Number(operatorSequence.poll());
        while (!operatorSequence.isEmpty()) {
            String operator = operatorSequence.poll();
            Number secondValue = new Number(operatorSequence.poll());
            firstValue = Operator.calculate(firstValue, operator, secondValue);
        }

        return firstValue;
    }

    private static String[] split(String strOperation) {
        return strOperation.split(" ");
    }

    private static void validateStringOperation(String strOperation) {
        if (isNullOrEmptyString(strOperation)) {
            throw new IllegalArgumentException("사칙연산을 입력해주세요.");
        }
    }

    private static boolean isNullOrEmptyString(String strOperation) {
        return strOperation == null || strOperation.isEmpty();
    }
}
