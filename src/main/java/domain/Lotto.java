package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_RANGE = 6;
    private List<Number> numbers = new ArrayList();

    public Lotto(Random random) {
        sort(sub(shuffle(getRandomNumbers(), random)))
                .forEach(v -> numbers.add(new Number(v)));
    }

    private static List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> shuffle(List<Integer> numbers, Random random) {
        Collections.shuffle(numbers, random);
        return numbers;
    }

    private static List<Integer> getRandomNumbers() {
        return IntStream.range(LOTTO_MIN_NUM, LOTTO_MAX_NUM).boxed().collect(Collectors.toList());
    }

    private static List<Integer> sub(List<Integer> numbers) {
        return numbers.subList(0, LOTTO_RANGE);
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
