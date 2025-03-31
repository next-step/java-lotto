package step2.generate;

import step2.LotteryNumber;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RandomGenerate implements Generate {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<LotteryNumber> CACHED_NUMBERS;

    static {
        CACHED_NUMBERS = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHED_NUMBERS.add(new LotteryNumber(i));
        }
    }

    @Override
    public Set<LotteryNumber> makeNumbers(int size) {
        List<LotteryNumber> numbers = new ArrayList<>(CACHED_NUMBERS);
        Collections.shuffle(numbers);
        return new HashSet<>(numbers.subList(0, size));
    }
}
