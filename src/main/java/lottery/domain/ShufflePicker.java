package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShufflePicker implements Picker {
    private final List<LotteryNumber> basis;

    public ShufflePicker() {
        basis = IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX)
                .mapToObj(LotteryNumber::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<LotteryNumber> pick() {
        Collections.shuffle(basis);
        return basis.subList(0, Lottery.COUNT_LOTTERY_NUMBER);
    }
}
