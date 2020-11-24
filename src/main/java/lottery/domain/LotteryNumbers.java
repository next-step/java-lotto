package lottery.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private static final int COUNT_LOTTERY_NUMBER = 6;
    private final List<Integer> numbers;

    public LotteryNumbers(Picker picker) {
        this(picker.pick());
    }

    private LotteryNumbers(List<Integer> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != COUNT_LOTTERY_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        if (this.numbers.size() != COUNT_LOTTERY_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatched(LotteryNumbers another) {
        return (int) another.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
