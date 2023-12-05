package stringCalculator.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

public class Operand {
    private static final String DELIMITER = " ";
    private Queue<String> values;

    public Operand(String input) {
        this.values = splitInput(input);
    }

    private Queue<String> splitInput(String input) {
        return new ArrayDeque<>(Arrays.asList(input.split(DELIMITER)));
    }

    public int calculate() {
        int currentNumber = Integer.parseInt(this.values.poll());
        Operator operator;
        int toCalculateNumber;
        while (this.values.isEmpty()) {
            operator = Operator.find(this.values.poll());
            toCalculateNumber = Integer.parseInt(this.values.poll());
            currentNumber = operator.calculate(currentNumber, toCalculateNumber);
        }
        return currentNumber;
    }

    public Queue<String> value() {
        return this.values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.values.getClass() != o.getClass()) return false;

        return areQueuesEqual(this.values, (ArrayDeque<String>) o);
    }

    private boolean areQueuesEqual(Queue<String> queue1, Queue<String> queue2) {
        if (queue1.size() != queue2.size()) {
            return false;
        }

        return IntStream.range(0, queue1.size()).allMatch(index -> Objects.equals(queue1.toArray()[index], queue2.toArray()[index]));
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
