package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    public static int start(String formula) {
        List<String> elements = List.of(formula.split(" "));

        return execute(elements);
    }

    public static int execute(List<String> elements) {
        Queue<String> es = new LinkedList<>();
        for (String element: elements) {
            es.add(element);
        }

        int result = Integer.parseInt(es.poll());
        while (!es.isEmpty()) {
            String operator = es.poll();
            int b = Integer.parseInt(es.poll());

            if (Objects.equals(operator, "+")) {
                result = result + b;
            }

            if (Objects.equals(operator, "*")) {
                result = result * b;
            }

            if (Objects.equals(operator, "-")) {
                result = result - b;
            }

            if (Objects.equals(operator, "/")) {
                result = result / b;
            }
        }

        return result;
    }
}
