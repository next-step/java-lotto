package calculator.domain;

import java.util.Queue;

public class Calculator {

    public int calculate(Queue<String> parsedQueue) {

        int result = Integer.parseInt(parsedQueue.poll());

        while (!parsedQueue.isEmpty()) {
            int first = result;
            String operator = parsedQueue.poll();
            int second = Integer.parseInt(parsedQueue.poll());
            result = Operator.of(operator).operate(first, second);
        }
        return result;
    }
}
