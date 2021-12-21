package step2.domain.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGenerator {
    public final static int LOTTERY_SIZE = 6;
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    private static List<Integer> randomList = IntStream.range(MIN_VALUE, MAX_VALUE)
            .mapToObj(i -> i)
            .collect(Collectors.toList());

    public static List<Integer> pickNumbers() {
        Collections.shuffle(randomList);

        List<Integer> extract = randomList.subList(0, LOTTERY_SIZE);
        extract.sort(Integer::compareTo);

        return extract;
    }
}
