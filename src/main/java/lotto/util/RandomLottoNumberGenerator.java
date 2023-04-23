package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator {
    public static final int LOTTERY_MIN_NUMBER = 1;
    public static final int LOTTERY_MAX_NUMBER = 45;

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }
}
