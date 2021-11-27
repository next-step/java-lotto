package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbers {
    private static final int LOTTERY_START_SIZE = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 46;

    private final List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers() {
        this.lotteryNumbers = balls();
    }

    private List<LotteryNumber> balls() {
        return IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
                .mapToObj(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public List<LotteryNumber> bringNumber() {
        Collections.shuffle(lotteryNumbers);

        return Collections.unmodifiableList(lotteryNumbers.subList(LOTTERY_START_SIZE, LOTTERY_END_SIZE)
                .stream()
                .sorted(Comparator.comparing(LotteryNumber::value))
                .collect(Collectors.toList()));
    }

}
