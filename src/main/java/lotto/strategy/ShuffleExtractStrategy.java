package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExtractStrategy implements ExtractStrategy {
    private static final int MAX_LOTTO_NUMBER = 45;

    @Override
    public List<Integer> extractNumber(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, number);
    }
}
