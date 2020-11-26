package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {
    public static final int COUNT_LOTTERY_NUMBER = 6;

    private final SortedSet<LotteryNumber> numbers;

    public static Lottery from(Picker picker) {
        return new Lottery(picker.pick(COUNT_LOTTERY_NUMBER));
    }

    private static void sanitizeLottery(Collection<LotteryNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != COUNT_LOTTERY_NUMBER) {
            throw new InconsistentLotteryException();
        }
    }

    protected Lottery(Collection<LotteryNumber> numbers) {
        sanitizeLottery(numbers);
        this.numbers = new TreeSet<>(numbers);
        sanitizeLottery(this.numbers);
    }

    public List<LotteryNumber> getNumbers() {
        return numbers.stream().collect(Collectors.toUnmodifiableList());
    }
}
