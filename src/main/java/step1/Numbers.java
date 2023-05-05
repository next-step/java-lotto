package step1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Numbers {
    private final Deque<Integer> numbers = new ArrayDeque<>();

    public Numbers(String[] numbersAndSigns) {
        for (int i = 0; i < numbersAndSigns.length; i = i + 2) {
            numbers.add(toNumber(numbersAndSigns[i]));
        }
    }

    private Integer toNumber(String numberString) {
        return Integer.parseInt(numberString);
    }

    public Integer pop() {
        return numbers.pop();
    }
}
