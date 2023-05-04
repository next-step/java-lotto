package stringcalculator.domain;

import java.util.Deque;

public class Numbers {

    private final Deque<Integer> numbers;

    public Numbers(Deque<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer remove() {
        return numbers.remove();
    }

    public void addFirst(Integer number) {
        numbers.addFirst(number);
    }

}
