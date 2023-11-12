package study.step1.domain;

import java.util.Objects;
import java.util.Queue;

import study.step1.domain.dto.Input;
import study.step1.domain.type.Operator;

public class Calculator {

    private final Input input;
    private final Calculation calculator;

    private int latestValue = 0;

    public Calculator(String[] input) {
        this(input, new DefaultCalculation());
    }

    public Calculator(String[] input, Calculation calculator) {
        this.input = new Input(input);
        this.calculator = calculator;
    }

    public int calculate() {
        Queue<Integer> numbers = input.getNumbers();
        Queue<Operator> operators = input.getOperators();
        latestValue = Objects.requireNonNull(numbers.poll());
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            process(operators.poll(), numbers.poll());
        }
        return latestValue;
    }

    private void process(Operator operator, int number) {
        isPlus(operator, number);
        isMinus(operator, number);
        isTimes(operator, number);
        isDivide(operator, number);
    }

    private void isPlus(Operator operator, int number) {
        if (operator.isPlus()) {
            latestValue = calculator.plus(latestValue, number);
        }
    }

    private void isMinus(Operator operator, int number) {
        if (operator.isMinus()) {
            latestValue = calculator.minus(latestValue, number);
        }
    }

    private void isTimes(Operator operator, int number) {
        if (operator.isTimes()) {
            latestValue = calculator.times(latestValue, number);
        }
    }

    private void isDivide(Operator operator, int number) {
        if (operator.isDivide()) {
            latestValue = calculator.divide(latestValue, number);
        }
    }

}
