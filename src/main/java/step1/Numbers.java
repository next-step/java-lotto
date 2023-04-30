package step1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Numbers {
    private final Deque<Integer> numbers = new ArrayDeque<>();

    public static Integer toNumber(String numberString) {
        return Integer.parseInt(numberString);
    }

    public static Numbers toNumbers(String[] numbersAndSigns) {
        Numbers numbers = new Numbers();
        for (int i = 0; i < numbersAndSigns.length; i = i + 2) {
            numbers.add(toNumber(numbersAndSigns[i]));
        }
        return numbers;
    }

    public Integer pop() {
        return numbers.pop();
    }

    public void add(Integer number) {
        numbers.add(number);
    }
}
