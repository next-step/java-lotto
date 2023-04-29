package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public static final int MIN_LOTTERY_NUM = 1;
    public static final int MAX_LOTTERY_NUM = 45;
    public static final int LOTTERY_SIZE = 6;

    private static final List<Integer> numbers = IntStream
            .rangeClosed(MIN_LOTTERY_NUM, MAX_LOTTERY_NUM)
            .boxed()
            .collect(Collectors.toList());
    private final List<Integer> lotteryNumber;

    public Lottery(List<Integer> lotteryNumber) {
        this.lotteryNumber = List.copyOf(lotteryNumber);
    }

    public static Lottery createAutoLottery() {
        Collections.shuffle(numbers);
        return new Lottery(numbers.stream()
                .limit(LOTTERY_SIZE)
                .sorted()
                .collect(Collectors.toList()));
    }

    public int matchedCount(List<Integer> winningNumbers) {
        return (int)lotteryNumber.stream()
                .filter(winningNumbers::contains).count();
    }

    @Override
    public String toString() {
        return lotteryNumber.toString();
    }
}
