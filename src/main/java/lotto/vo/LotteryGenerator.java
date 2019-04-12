package lotto.vo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGenerator {
    private static final int START_LOTTERY_NUMBER = 1;
    private static final int END_LOTTERY_NUMBER = 45;
    private static final int FROM_LOTTERY_INDEX = 0;
    private static final int TO_LOTTERY_INDEX = 6;

    public LotteryNumbers lotteryGenerator(Money money) {
        return new LotteryNumbers(toNumbers(money.divide(money)));
    }

    private List<LotteryNumber> toNumbers(int ticketCount) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lotteryNumbers.add(lottoMake());
        }
        return lotteryNumbers;
    }

    private LotteryNumber lottoMake() {
        List<Integer> lotteryFullNumbers = createLotteryNumbers();
        Collections.shuffle(lotteryFullNumbers);
        return LotteryNumber.toObject(split6digit(lotteryFullNumbers));
    }

    private Set<Integer> split6digit(List<Integer> lotteryFullNumbers) {
        return new HashSet<>(lotteryFullNumbers.subList(FROM_LOTTERY_INDEX, TO_LOTTERY_INDEX));
    }

    private List<Integer> createLotteryNumbers() {
        return IntStream.rangeClosed(START_LOTTERY_NUMBER, END_LOTTERY_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
