package step2.domain.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGenerator {
    private final static int LOTTERY_NUMBER_COUNT = 6;
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    private static List<Integer> randomList = IntStream.range(MIN_VALUE, MAX_VALUE)
            .mapToObj(i -> i)
            .collect(Collectors.toList());

    public static List<Integer> pickNumbers() {
        Collections.shuffle(randomList);

        List<Integer> extract = randomList.subList(0, LOTTERY_NUMBER_COUNT);
        extract.sort(Integer::compareTo);

        return extract;
    }
}
