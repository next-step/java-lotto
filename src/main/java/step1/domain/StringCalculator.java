package step1.domain;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    public static Number calc(String strOperation) {
        validateStringOperation(strOperation);

        Queue<String> operatorSequence = new ArrayDeque<>();
        operatorSequence.addAll(List.of(split(strOperation)));

        Number firstValue = new Number(operatorSequence.poll());
        Number cumulativeValue = firstValue;
        while (!operatorSequence.isEmpty()) {
            String operator = operatorSequence.poll();
            Number number = new Number(operatorSequence.poll());
            cumulativeValue = Operator.calculate(cumulativeValue, operator, number);
        }

        return cumulativeValue;
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
