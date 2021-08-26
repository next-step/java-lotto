package lottery_auto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;

public class LotteryStrategyImpl implements LotteryStrategy {

    private static final int LOTTO_IDX_ZERO = 0;
    private static final int LOTTO_IDX = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final List<Integer> NUMBERS = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        setRandomNumber();

        return new ArrayList<>(NUMBERS.subList(LOTTO_IDX_ZERO, LOTTO_IDX)).stream()
                .sorted()
                .collect(Collectors.toList());

    }

    private void setRandomNumber() {
        rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .forEach(NUMBERS::add);

        shuffle(NUMBERS);
    }


}
