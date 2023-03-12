package lottery;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private static final int LOTTERY_LIMIT = 45;
    private static final int LOTTERY_TICKET_LENGTH = 6;
    private final int[] lotteryRange = IntStream.rangeClosed(1, LOTTERY_LIMIT)
                                                .toArray();
    private final List<Integer> lotteryNumbers;
    public Lottery() {
        lotteryNumbers = publishLottery();
    }

    public int[] getLotteryRange() {
        return lotteryRange;
    }

    private List<Integer> publishLottery() {
        List<Integer> shuffleNumber =
                Arrays.stream(lotteryRange)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.shuffle(Arrays.asList(shuffleNumber));
        return shuffleNumber.subList(0, LOTTERY_TICKET_LENGTH);
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }
}


