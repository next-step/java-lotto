package step1;

import java.util.Queue;

public class Calculator {

    private final Queue<Integer> numbers;
    private final Queue<Operator> operators;

    public Calculator(Queue<Integer> numbers, Queue<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public int calculate() {
        Integer result = numbers.poll();
        while(!operators.isEmpty()) {
            result = operators.poll().apply(result, numbers.poll());
        }
        return result;
    }
}
