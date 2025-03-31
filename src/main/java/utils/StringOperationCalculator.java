package utils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class StringOperationCalculator {
    private StringOperationCalculator() {}

    public static String calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("input은 null 이거나, 빈값일 수 없습니다.");
        }

        return reduceOperation(makeList(split(input)));
    }

    private static String reduceOperation(Deque<String> numOpList) {
        while (numOpList.size() > 1) {
            String leftOperand = numOpList.pollFirst();
            StringOperator operator = StringOperator.from(numOpList.pollFirst());
            String rightOperand = numOpList.pollFirst();
            String result = operator.calculate(leftOperand, rightOperand);

            numOpList.addFirst(result);
        }

        return numOpList.pollFirst();
    }

    private static Deque<String> makeList(String[] numOpList) {
        return new LinkedList<>(Arrays.asList(numOpList));
    }

    private static String[] split(String input) {
        return input.split(" ");
    }
}
