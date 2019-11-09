package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryGenerator {

    private static final int NUMBER_SIZE = 6;
    private static final int TICKET_PRICE = 1_000;

    private final List<LotteryNumber> BASE;

    public LotteryGenerator() {
        BASE = IntStream
                .rangeClosed(LotteryNumber.LOTTERY_NUMBER_MIN, LotteryNumber.LOTTERY_NUMBER_MAX)
                .mapToObj(LotteryNumber::of)
                .collect(toList());
    }

    public List<LotteryTicket> generate(int amount, List<List<Integer>> manualLotteries) {

        List<LotteryTicket> tickets = manualLotteries.stream()
                .map(LotteryTicket::from)
                .collect(toList());

        int autoCount = calculateAutoCount(amount, manualLotteries.size());
        for (int i = 0; i < autoCount; i++) {
            tickets.add(new LotteryTicket(generateAutoNumbers(NUMBER_SIZE)));
        }

        return tickets;
    }

    private int calculateAutoCount(int amount, int manualCount) {
        return (amount - manualCount * TICKET_PRICE) / TICKET_PRICE;
    }

    public List<LotteryNumber> generateAutoNumbers(int limit) {
        Collections.shuffle(BASE);
        return BASE.stream()
                .limit(limit)
                .sorted(Comparator.comparingInt(LotteryNumber::hashCode))
                .collect(toList());
    }

}
