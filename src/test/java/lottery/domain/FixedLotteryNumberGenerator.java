package lottery.domain;

import java.util.List;

public class FixedLotteryNumberGenerator implements LotteryNumberGenerator {

    private final List<Integer> numbers;

    public FixedLotteryNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LotteryNumberGenerator create(final List<Integer> numbers) {
        return new FixedLotteryNumberGenerator(numbers);
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
