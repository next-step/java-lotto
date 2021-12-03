package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbers {
    private static final int LOTTERY_START_SIZE = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 46;

    private static final List<LotteryNumber> lotteryNumbers = balls();

    private LotteryNumbers() {
    }

    private static List<LotteryNumber> balls() {
        return IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
                .mapToObj(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public static Set<Integer> auto() {
        Collections.shuffle(lotteryNumbers);

        return IntStream.range(LOTTERY_START_SIZE, LOTTERY_END_SIZE)
                .mapToObj(i -> lotteryNumbers.get(i).value())
                .collect(Collectors.toSet());
    }

}
