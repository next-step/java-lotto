package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final int NUMBERS_COUNT = 6;

    public static final int PRICE = 1000;

    private final List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<Integer> numbers) {
        if (NUMBERS_COUNT != numbers.size()) {
            throw new IllegalArgumentException();
        }
        this.lotteryNumbers = numbers.stream()
                .sorted()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lotteryNumbers.toString();
    }
}
