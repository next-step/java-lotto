package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShufflePicker implements Picker {
    private static final List<LotteryNumber> BASIS =
            IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX)
                .mapToObj(LotteryNumber::valueOf)
                .collect(Collectors.toList());

    @Override
    public List<LotteryNumber> pick() {
        Collections.shuffle(BASIS);
        return BASIS.subList(0, Lottery.COUNT_LOTTERY_NUMBER);
    }
}
