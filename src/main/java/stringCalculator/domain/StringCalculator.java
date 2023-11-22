package stringCalculator.domain;

import stringCalculator.enums.Operator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class StringCalculator {

    public static int calculate(String input) {
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList(Parser.parseInput(input)));
        int result = Integer.parseInt(Objects.requireNonNull(stringQueue.poll()));

        while (!stringQueue.isEmpty()) {
            result = processCalc(stringQueue, result);
        }

        return result;
    }

    private static int processCalc(Queue<String> stringQueue, int processedValue) {
        return Operator.fromString(stringQueue.poll()).map(operator -> operator.apply(processedValue, Integer.parseInt(stringQueue.poll())))
                .orElseThrow(() -> new IllegalArgumentException("사칙연산에 해당하는 기호가 아닙니다."));
    }

}
