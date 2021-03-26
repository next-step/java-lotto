package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int START = 1;
    public static final int END = 45;
    public static final int LOTTO_NUMBER = 6;
    private static final List<Integer> range = IntStream.range(START, END + 1)
            .boxed()
            .collect(Collectors.toList());

    private List<Integer> numbers;

    public Lotto() {
        numbers = creatNumbers();
    }

    private List<Integer> creatNumbers() {
        Collections.shuffle(range);
        List<Integer> numbers = new ArrayList<>(range.subList(0, LOTTO_NUMBER));
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
