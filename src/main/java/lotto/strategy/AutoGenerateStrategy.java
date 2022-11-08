package lotto.strategy;

import lotto.domain.LotteryNumber;
import lotto.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoGenerateStrategy {
    public static final List<LotteryNumber> numbers = IntStream.range(LotteryNumber.MIN_VALUE, LotteryNumber.MAX_NUMBER)
            .mapToObj(LotteryNumber::valueOf)
            .collect(Collectors.toList());

    public LotteryTicket generate() {
        Collections.shuffle(numbers);
        return new LotteryTicket(new ArrayList<>(numbers.subList(0, LotteryTicket.COUNT_OF_LOTTERY_NUMBER)));
    }
}
