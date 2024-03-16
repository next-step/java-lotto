package calculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {

    public static void validate(String[] targets) {
        if (targets.length < 3 || targets.length % 2 == 0) {
            throw new IllegalArgumentException("입력 문자열을 확인해주세요.");
        }
    }

    public static int calculate(String[] letters) {
        Deque<String> items = new ArrayDeque<>(Arrays.asList(letters));

        while (items.size() >= 3) {
            int a = Integer.parseInt(items.poll());
            Operator operator = Operator.findByName(items.poll());
            int b = Integer.parseInt(items.poll());

            items.addFirst(String.valueOf(operator.operate(a, b)));
        }

        return Integer.parseInt(items.poll());
    }
}
