package calculator.domain;

import java.util.Queue;

public class Calculator {

    public int calculate(Queue<String> parsedQueue) {

        int result = Integer.parseInt(parsedQueue.poll());

        while (!parsedQueue.isEmpty()) {
            int first = result;
            String operator = parsedQueue.poll();
            int second = Integer.parseInt(parsedQueue.poll());
            int operated = operate(first, operator, second);
            result = operated;
        }
        return result;
    }

    private int operate(int first, String operator, int second) {
        if (operator.equals("+")){
            return first + second;
        }
        if (operator.equals("-")){
            return first - second;
        }
        if (operator.equals("*")){
            return first * second;
        }
        else {
            if(second == 0) {
                throw new IllegalArgumentException("나눗셈 분모에 0이 올 수 없습니다.");
            }
            return first / second;
        }
    }
}
