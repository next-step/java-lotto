package step1.domain;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    private static Calculator calculator = new Calculator();

    public static Number calc(String strOperation) {
        validateStringOperation(strOperation);

        Queue<String> operatorSequence = new ArrayDeque<>();
        operatorSequence.addAll(List.of(split(strOperation)));

        Number firstValue = new Number(operatorSequence.poll());
        Number cumulativeValue = firstValue;
        while (!operatorSequence.isEmpty()) {
            Operator operator = new Operator(operatorSequence.poll());
            Number number = new Number(operatorSequence.poll());
            cumulativeValue = doOperation(cumulativeValue, operator, number);
        }

        return cumulativeValue;
    }

    private static String[] split(String strOperation) {
        return strOperation.split(" ");
    }

    private static Number doOperation(Number left, Operator op, Number right) {

        if (op.isAdd()) {
            return calculator.add(left, right);
        }
        if (op.isSubtract()) {
            return calculator.subtract(left, right);
        }
        if (op.isMultiply()) {
            return calculator.multiply(left, right);
        }
        if (op.isDivide()) {
            return calculator.divide(left, right);
        }

        throw new IllegalArgumentException();
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
