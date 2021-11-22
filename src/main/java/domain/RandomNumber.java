package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber {
    private static final int LOTTERY_START_SIZE = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 46;
    private static final List<Integer> lotteryBalls = IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private RandomNumber() {
    }

    public static List<Integer> bringNumber() {
        Collections.shuffle(lotteryBalls);
        return lotteryBalls.subList(LOTTERY_START_SIZE, LOTTERY_END_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
