package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int LOTTERY_NUM_MAX = 45;
    private static final int LOTTERY_NUM_COUNT = 6;

    private static final List<Integer> lotteryNumberCandidates = IntStream
            .range(1, LOTTERY_NUM_MAX + 1)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lotteryNumbers;

    public Lottery() {
        this(generateLotteryNumbers());
    }

    public Lottery(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return Collections.unmodifiableList(this.lotteryNumbers);
    }

    private static List<Integer> generateLotteryNumbers() {
        Collections.shuffle(lotteryNumberCandidates);
        List<Integer> lotteryNumbers = lotteryNumberCandidates.subList(0, LOTTERY_NUM_COUNT);
        Collections.sort(lotteryNumbers);

        return new ArrayList<>(lotteryNumbers);
    }

    public int countEqualNumbers(Lottery lottery) {
        return lottery.lotteryNumbers.stream()
                .filter(this.lotteryNumbers::contains)
                .mapToInt(lotteryNumber -> 1)
                .sum();
    }
}
