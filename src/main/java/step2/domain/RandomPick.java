package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomPick implements LottoPickStrategy {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int START_INDEX = 0;
    private static final int LAST_INDEX = 6;
    private static final List<Integer> BASE_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            BASE_NUMBERS.add(i);
        }
    }

    @Override
    public List<Integer> numberPick() {
        Collections.shuffle(BASE_NUMBERS);
        return List.copyOf(BASE_NUMBERS.subList(START_INDEX, LAST_INDEX));
    }
}
