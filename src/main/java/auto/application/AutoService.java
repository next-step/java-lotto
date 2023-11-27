package auto.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoService {
    private final static int LOTTERY_MIN_NUMBER = 1;
    private final static int LOTTERY_MAX_NUMBER = 45;

    public static List<List<Integer>> createLotteryNumbersList(int lotteryCount) {
        return IntStream.range(0, lotteryCount)
                        .mapToObj(i -> AutoService.createLotteryNumbers())
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Integer> createLotteryNumbers() {
        List<Integer> numbers = IntStream.range(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER + 1)
                                         .boxed()
                                         .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public static BigDecimal getReturnRate(int totalAmount, int amount) {
        return BigDecimal.valueOf(totalAmount)
                         .divide(BigDecimal.valueOf(amount));
    }
}
