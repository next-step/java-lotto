package step1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Numbers {
    private final Deque<Integer> numbers = new ArrayDeque<>();

    public static Integer toNumber(String numberString) {
        return Integer.parseInt(numberString);
    }

    public Integer pop() {
        return numbers.pop();
    }

    public void add(Integer number) {
        numbers.add(number);
    }
}
