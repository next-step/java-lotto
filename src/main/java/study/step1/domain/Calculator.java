package study.step1.domain;

import java.util.Objects;
import java.util.Queue;

import study.step1.domain.dto.Input;
import study.step1.domain.type.Operator;

public class Calculator {

    private final Input input;
    private int latestValue = 0;

    public Calculator(String[] input) {
        this.input = new Input(input);
    }

    public int calculate() {
        Queue<Integer> numbers = input.getNumbers();
        Queue<Operator> operators = input.getOperators();
        latestValue = Objects.requireNonNull(numbers.poll());
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            latestValue = process(operators.poll(), numbers.poll());
        }
        return latestValue;
    }

    private int process(Operator operator, int number) {
        return operator.calculate(latestValue, number);
    }
}
