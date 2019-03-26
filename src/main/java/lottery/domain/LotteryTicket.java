package lottery.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final int NUMBERS_COUNT = 6;

    private final Set<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<Integer> numbers) {
        this.lotteryNumbers = numbers.stream()
                .sorted()
                .map(LotteryNumber::of)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));

        if (this.lotteryNumbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lotteryNumbers.toString();
    }

    int countMatchNumbers(LotteryTicket target) {
        return (int) this.lotteryNumbers
                .stream()
                .filter(number -> target.contains(number))
                .count();
    }

    boolean contains(LotteryNumber number) {
        return this.lotteryNumbers
                .contains(number);
    }
}
