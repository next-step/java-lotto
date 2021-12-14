package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final int VALID_COUNT_OF_NUMBERS = 6;

    private RandomLotteryNumberGenerator() {
    }

    public static LotteryNumberGenerator create() {
        return new RandomLotteryNumberGenerator();
    }

    @Override
    public List<Integer> generate() {
        final List<Integer> allNumbers = IntStream.rangeClosed(LotteryNumber.MINIMUM_LOTTERY_NUMBER, LotteryNumber.MAXIMUM_LOTTERY_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(allNumbers);

        return allNumbers.stream()
            .limit(VALID_COUNT_OF_NUMBERS)
            .sorted()
            .collect(Collectors.toList());
    }
}
