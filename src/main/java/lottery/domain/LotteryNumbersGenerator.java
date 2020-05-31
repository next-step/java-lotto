package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbersGenerator {

    private static final List<Integer> LOTTERY_NUMBERS_LIST = IntStream
            .rangeClosed(LotteryNumber.MINIMUM_NUMBER, LotteryNumber.MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    private LotteryNumbersGenerator() {
    }

    public static List<LotteryNumber> generateAutomaticNumbers() {
        Collections.shuffle(LOTTERY_NUMBERS_LIST);
        List<Integer> pickedLotteryNumbers = LOTTERY_NUMBERS_LIST.subList(FIRST_INDEX, LAST_INDEX);
        Collections.sort(pickedLotteryNumbers);
        return pickedLotteryNumbers.stream()
                .map(LotteryNumber::from)
                .collect(Collectors.toList());
    }
}
