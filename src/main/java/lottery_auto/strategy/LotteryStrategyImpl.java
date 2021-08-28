package lottery_auto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;

public class LotteryStrategyImpl implements LotteryStrategy {

    private static final int LOTTO_IDX_ZERO = 0;
    private static final int LOTTO_IDX = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = shuffleNumber(disposeNumber());

        return new ArrayList<>(numbers.subList(LOTTO_IDX_ZERO, LOTTO_IDX))
                .stream()
                .sorted()
                .collect(Collectors.toList());

    }

    private List<Integer> disposeNumber() {
        List<Integer> numbers = new ArrayList<>();
        rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).forEach(numbers::add);
        return numbers;
    }

    private List<Integer> shuffleNumber(List<Integer> numbers) {
        shuffle(numbers);
        return numbers;
    }


}
