package stringcalculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Numbers {

    private Queue<Number> numbers;

    public Numbers(Queue<Number> numbers) {
        this.numbers = numbers;
    }

    public void offer(Number number) {
        this.numbers.offer(number);
    }

    public Number next() {
        return this.numbers.poll();
    }

    public boolean hasNext() {
        return this.numbers.iterator().hasNext();
    }

    public Queue<Number> clone() {
        return new LinkedList<>(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
