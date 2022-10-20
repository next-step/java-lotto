package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketAutoGenerator {
    public static final List<LotteryNumber> numbers = IntStream.range(LotteryNumber.MIN_VALUE, LotteryNumber.MAX_NUMBER)
            .mapToObj(LotteryNumber::new)
            .collect(Collectors.toList());

    public LotteryTicket generate() {
        Collections.shuffle(numbers);
        return new LotteryTicket(numbers.subList(0, LotteryTicket.COUNT_OF_LOTTERY_NUMBER));
    }
}
