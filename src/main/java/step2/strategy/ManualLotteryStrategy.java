package step2.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLotteryStrategy implements LotteryStrategy {
    private List<Integer> numbers;

    public ManualLotteryStrategy(String numbers) {
        this.numbers = Arrays.stream(numbers.split(","))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getLotteryNumbers() {
        return numbers;
    }
}
