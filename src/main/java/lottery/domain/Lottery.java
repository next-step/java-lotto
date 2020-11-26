package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {
    public static final int COUNT_LOTTERY_NUMBER = 6;

    private final SortedSet<LotteryNumber> numbers;

    private static void sanitizeLottery(Collection<LotteryNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != COUNT_LOTTERY_NUMBER) {
            throw new InconsistentLotteryException();
        }
    }

    public Lottery(Picker picker) {
        this(picker.pick(COUNT_LOTTERY_NUMBER));
    }

    private Lottery(Collection<LotteryNumber> numbers) {
        sanitizeLottery(numbers);
        this.numbers = new TreeSet<>(numbers);
        sanitizeLottery(this.numbers);
    }

    public int countMatched(Lottery another) {
        return (int) another.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public List<LotteryNumber> getNumbers() {
        return numbers.stream().collect(Collectors.toUnmodifiableList());
    }
}
