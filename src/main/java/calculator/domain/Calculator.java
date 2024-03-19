package calculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {


    public static int calculate(String[] tokens) {
        validateLength(tokens);
        validateElements(tokens);

        Deque<String> items = new ArrayDeque<>(Arrays.asList(tokens));

        while (items.size() >= 3) {
            int a = Integer.parseInt(items.poll());
            Operator operator = Operator.findBySign(items.poll());
            int b = Integer.parseInt(items.poll());

            items.addFirst(String.valueOf(operator.operate(a, b)));
        }

        return Integer.parseInt(items.poll());
    }

    private static void validateLength(String[] tokens) {
        if (tokens.length < 3 || tokens.length % 2 == 0) {
            throw new IllegalArgumentException("입력 문자열을 확인해주세요.");
        }
    }

    private static void validateElements(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String item = tokens[i];

            if (i % 2  == 0) {
                Integer.parseInt(item);
                continue;
            }
            Operator.findBySign(item);
        }
    }
}
