package lottery.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final Money TICKET_PRICE = new Money(1000);

    public static final int NUMBERS_COUNT = 6;

    final Set<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<Integer> numbers) {
        this.lotteryNumbers = numbers.stream()
                .sorted()
                .map(LotteryNumber::new)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));

        if (this.lotteryNumbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lotteryNumbers.toString();
    }
}
