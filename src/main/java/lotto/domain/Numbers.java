package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Numbers {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(START_NUM, END_NUM).forEach(i -> numbers.add(i));
    }

    public static List<Integer> getNumbers() {
        return numbers;
    }
}
