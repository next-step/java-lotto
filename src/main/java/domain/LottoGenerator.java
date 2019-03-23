package domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_RANGE = 6;

    public static List<Number> run(Random random) {
        return toNumber(sort(sub(shuffle(getRandomNumbers(), random))));
    }

    private static List<Number> toNumber(List<Integer> numbers) {
        return numbers.stream().map(v -> new Number(v)).collect(Collectors.toList());
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
}
